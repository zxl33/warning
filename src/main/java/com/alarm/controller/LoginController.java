package com.alarm.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alarm.entity.Manager;
import com.alarm.service.ManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sun.misc.BASE64Encoder;

@Controller
public class LoginController {
	
	@Autowired
	ManagerService managerService;

	@RequestMapping("/login")
    public String testInDb(Model model)
	{
		return "/login2";
	}
	
	//本方法将处理 /login/check,登录用户验证,基本完成08-10
	@RequestMapping(value="/login/check", method=RequestMethod.POST)
	public void LoginCheck(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException 
	{
		HttpSession session = request.getSession();
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if(request.getParameter("authCode").equals(session.getAttribute("strCode")))
		{
			String encode_password = (new BASE64Encoder()).encodeBuffer(request.getParameter("password").getBytes());
			Manager manager=new Manager();
			manager.setEmail(request.getParameter("email"));
			manager.setPassword(encode_password);
			
			Manager mg = managerService.checkManager(manager);
			
		    if(mg == null)
		    {
		    	jsonMap.put("success",false);
			    jsonMap.put("message", "email or password wrong");
		    }else {
		    	session.setAttribute("name", mg.getName());
		    	jsonMap.put("success",true);
			    jsonMap.put("message", "success");
			    jsonMap.put("data", mg);
		    }
		}
		else
		{
			jsonMap.put("success",false);
		    jsonMap.put("message", "autocode maybe wrong");
		}
	    ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(jsonMap);
	    try {
	        //设置页面不缓存
	        response.setContentType("application/json");
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out= null;
	        out = response.getWriter();
	        out.print(json);
	        out.flush();
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//验证是否已登录
	public void returnLogin(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
    	if(session.getAttribute("name") == null)
    	{
    		response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/login");
    	}
	}
	
	//
	@RequestMapping({"authCode"})
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)
            throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute("strCode", strCode);
        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();

    }
	
	//创建颜色
    Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }
}
