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

import com.alarm.entity.Temp;
import com.alarm.service.TempService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/temp2")
public class TempController {

	@Autowired
	TempService tempService;

	@Autowired
	LoginController loginController;

	//通知模板列表页面
	@RequestMapping(value = "/temp2")
	public String tempList(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		loginController.returnLogin(request, response);
		return "/temp2";
	}

	//通知模板列表数据
	@RequestMapping(value = "/temp.data", method = RequestMethod.POST)
	public void tempData(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		List<Temp> templist = tempService.getAllTemp();
		//设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonMap.put("message", "success");
		jsonMap.put("data", templist);
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

	//通知模板新增
	@RequestMapping(value = "/temp.add", method = RequestMethod.POST)
	public void tempAdd(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		String name = request.getParameter("name");
		Boolean symbol;
		String message;
		if (tempService.getTempByName(name) == null) {
			Temp temp = new Temp();
			temp.setName(request.getParameter("name"));
			if (request.getParameter("type") == "0") {
				temp.setType(false);
			}
			else {
				temp.setType(true);
			}
			temp.setContent(request.getParameter("content"));
			tempService.addTemp(temp);
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

	//通知模板新增
	@RequestMapping(value = "/temp.look", method = RequestMethod.POST)
	public void tempLook(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		Temp temp = new Temp();
		temp = tempService.getTempByName(request.getParameter("name"));
		//设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonMap.put("message", "success");
		jsonMap.put("data", temp);
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

	//通知模板删除
	@RequestMapping(value = "/temp.delete", method = RequestMethod.POST)
	public void tempDelete(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		Temp temp = new Temp();
		temp.setTemp_id(Integer.parseInt(request.getParameter("id")));
		tempService.deleteTemp(temp);
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
