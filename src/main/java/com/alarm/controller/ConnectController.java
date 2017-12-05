package com.alarm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alarm.service.TempService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/connect")
public class ConnectController {

	@Autowired
	TempService tempService;

	//本方法将处理 /connect/mail.temp,0,模板名字列表
	@RequestMapping(value = "/mail.temp", method = RequestMethod.GET)
	public void viewList(HttpServletResponse response) throws JsonProcessingException {
		List<String> namelist = tempService.findTempByType(false);

		//设置页面数据
		Map<String, Object> dataMap = new HashMap<String, Object>();
		for (int i = 0; i < namelist.size(); i++) {
			Map<String, String> temp_map = new HashMap<String, String>();
			temp_map.put("label", namelist.get(i));
			dataMap.put(namelist.get(i), temp_map);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String, Object> selectorData = new HashMap<String, Object>();
		selectorData.put("selectorData", dataMap);
		selectorData.put("total", namelist.size());
		jsonMap.put("success", true);
		jsonMap.put("data", selectorData);
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

	//本方法将处理 /connect/mail.temp,1,模板名字列表
	@RequestMapping(value = "/note.temp", method = RequestMethod.GET)
	public void noteviewList(HttpServletResponse response) throws JsonProcessingException {
		List<String> namelist = tempService.findTempByType(true);

		//设置页面数据
		Map<String, Object> dataMap = new HashMap<String, Object>();
		for (int i = 0; i < namelist.size(); i++) {
			Map<String, String> temp_map = new HashMap<String, String>();
			temp_map.put("label", namelist.get(i));
			dataMap.put(namelist.get(i), temp_map);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String, Object> selectorData = new HashMap<String, Object>();
		selectorData.put("selectorData", dataMap);
		selectorData.put("total", namelist.size());
		jsonMap.put("success", true);
		jsonMap.put("data", selectorData);
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
