package com.alarm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alarm.entity.Manager;
import com.alarm.service.ManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sun.misc.BASE64Encoder;

@Controller
@RequestMapping(value = "/manager2")
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@Autowired
	LoginController loginController;

	//管理员列表页面
	@RequestMapping(value = "/manager2")
	public String managerList(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		loginController.returnLogin(request, response);
		return "/manager2";
	}

	//管理员列表数据
	@RequestMapping(value = "/manager.data", method = RequestMethod.POST)
	public void managerData(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		List<Manager> managerlist = managerService.getAllManager();
		Integer managerlist_size = managerlist.size();
		for (int i = 0; i < managerlist_size; i++) {
			managerlist.get(i).setPassword(null);
		}
		//设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonMap.put("message", "success");
		jsonMap.put("data", managerlist);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jsonMap);
		try {
			//设置页面不缓存
			response.setContentType("application/json");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = null;
			out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//管理员新增
	@RequestMapping(value = "/manager.add", method = RequestMethod.POST)
	public void managerAdd(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		String name = request.getParameter("name");
		Boolean symbol;
		String message;
		if (managerService.getManagerByName(name) == null) {
			String encode_password = (new BASE64Encoder())
					.encodeBuffer(request.getParameter("password").getBytes());
			Manager manager = new Manager();
			manager.setName(request.getParameter("name"));
			manager.setEmail(request.getParameter("email"));
			manager.setPassword(encode_password);
			managerService.addManager(manager);
			symbol = true;
			message = "success";
		}
		else {
			symbol = false;
			message = "名字重复";
		}

		//设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", symbol);
		jsonMap.put("message", message);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jsonMap);
		try {
			//设置页面不缓存
			response.setContentType("application/json");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = null;
			out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//管理员删除
	@RequestMapping(value = "/manager.delete", method = RequestMethod.POST)
	public void managerDelete(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		Manager manager = new Manager();
		manager.setManager_id(Integer.parseInt(request.getParameter("id")));
		managerService.deleteManager(manager);
		//managerService.deleteManager(manager);

		//设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonMap.put("message", "success");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jsonMap);
		try {
			//设置页面不缓存
			response.setContentType("application/json");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = null;
			out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
