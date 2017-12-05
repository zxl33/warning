package com.alarm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alarm.entity.Message;
import com.alarm.service.AssemblyService;
import com.alarm.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	@Autowired
	AssemblyService assemblyService;

	@Autowired
	LoginController loginController;

	//显示告警页面
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//loginController.returnLogin(request, response);
		//messageService.countMessage(1);已测试可用
		return "/message";
	}

	//传输告警列表数据
	@RequestMapping(value = "/message.data", method = RequestMethod.POST)
	public void messageData(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		String assembly = null;
		String start_time = null;
		String end_time = null;
		if (request.getParameter("start_time") != null
				&& request.getParameter("start_time") != "") {
			start_time = request.getParameter("start_time");
		}
		if (request.getParameter("end_time") != null && request.getParameter("end_time") != "") {
			end_time = request.getParameter("end_time");
		}
		List<Message> messagelist = new ArrayList();
		//如果获取不为空值，根据名字找ID
		if (request.getParameter("assembly_name") != null
				&& request.getParameter("assembly_name") != "") {
			assembly = request.getParameter("assembly_name");
			//TODO：从assembly_name 到 id_list的映射
			List<Integer> idlist = assemblyService.getAssemblyIDByName(assembly);
			if (idlist.size() > 0) {
				for (int i = 0; i < idlist.size(); i++) {
					List<Message> templist = messageService.getMessage(idlist.get(i), start_time,
							end_time);
					for (int j = 0; j < templist.size(); j++) {
						messagelist.add(templist.get(j));
					}
				}
			}
			else {
				messagelist = null;
			}
		}
		//如果获取为空值，直接找数据库
		else {
			messagelist = messageService.getMessageByTime(start_time, end_time);
		}

		//TODO：把list里的id映射到name
		Map<Integer, String> id_name_map = new HashMap<Integer, String>();
		if (messagelist != null) {
			for (int i = 0; i < messagelist.size(); i++) {
				id_name_map.put(messagelist.get(i).getAssembly_id(),
						assemblyService.getAssemblyNameByID(messagelist.get(i).getAssembly_id()));
			}
		}

		//设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonMap.put("message", "success");
		jsonMap.put("data", messagelist);
		jsonMap.put("data2", id_name_map);
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

	//处理操作，保存修改数据
	@RequestMapping(value = "/action.data", method = RequestMethod.POST)
	public void actionData(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		Message message = new Message();
		message.setMessage_id(Integer.parseInt(request.getParameter("message_id")));
		message.setAction_reason(request.getParameter("action_reason"));
		message.setAction_describe(request.getParameter("action_desc"));
		message.setAction(Boolean.parseBoolean(request.getParameter("action")));
		messageService.dealMessage(message);

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

	//页面弹出操作处理框，根据告警ID返回action内容
	@RequestMapping(value = "/single.message.data", method = RequestMethod.POST)
	public void singleMessageData(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		Message message = messageService
				.findMessageById(Integer.parseInt(request.getParameter("id")));
		//设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonMap.put("message", "success");
		jsonMap.put("data", message);
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

	//告警信息接受接口
	@RequestMapping(value = "/message.connect", method = RequestMethod.POST)
	public void messageConnect(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		Message message = new Message();
		message.setAssembly_id(Integer.parseInt(request.getParameter("assembly_name")));
		message.setContinue_time(Integer.parseInt(request.getParameter("continue_time")));
		message.setLast_time(request.getParameter("last_time"));
		message.setTimes(Integer.parseInt(request.getParameter("times")));
		message.setServer_type(request.getParameter("server_type"));
		message.setService_type(request.getParameter("service_type"));
		message.setRoom(request.getParameter("room"));
		message.setGroup(request.getParameter("group"));
		messageService.addMessage(message);
		//发送邮件给负责人
	}
}
