package com.alarm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.entity.Assembly;
import com.alarm.helper.ComponentInfoHelper;
import com.alarm.helper.Data4CInfo;
import com.alarm.service.AssemblyService;

/**
 * 
    * @ClassName: IndexController
    * @Description:首页路由 ---注解@Controller
    * @author joe
    * @date 2015-11-19
    *
 */
@Controller
public class IndexController {

	@Autowired
	AssemblyService assemblyService;
	//@Autowired
	//LoginController loginController;

	@RequestMapping("/tempHelper")
	public String tempH(Model model) {

		return "/tempHelper";

	}

	@RequestMapping("/managerHelper")
	public String managerH(Model model) {

		return "/managerHelper";

	}

	@RequestMapping("/messageHelper")
	public String messageH(Model model) {

		return "/messageHelper";

	}

	//测试告警信息列表
	@RequestMapping("/messageList")
	public String messageList(Model model) {

		return "/MessageList";

	}

	@RequestMapping("/test")
	public String testInDb(Model model) {

		return "/login2.jsp";

	}

	@RequestMapping("/testAdmin")
	public String testAdmin() {

		return "/adminManagement";

	}

	@RequestMapping("/testList")
	public String testList(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//	loginController.returnLogin(request, response);

		return "/componentList";

	}

	@RequestMapping("/testCM")
	public String testCM(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//	loginController.returnLogin(request, response);

		return "/componentManagement";

	}

	@RequestMapping("/testCO")
	public String testCO(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//	loginController.returnLogin(request, response);

		return "/componentOperation";

	}

	//	@RequestMapping("/testList")
	//	public String testWIL() {

	//		return "/warningInfoList";
	//	}

	@RequestMapping("demo/simple/componentEdit/{componentId}")

	public String gotoComponentOperation() {
		return "/componentOperation";
	}

	@RequestMapping("demo/simple/componentEdit/assembly/getNameAndLeader")
	@ResponseBody
	public ComponentInfoHelper getNameAndLeaderByID(
			@RequestParam(value = "id", required = false) int id) {
		//System.out.println("@@@@@获取到响应了啦啦啦");
		Assembly assembly = assemblyService.getAssemblyByOne(id);
		Data4CInfo data4cInfo = new Data4CInfo();
		data4cInfo.setComponentInfo(assembly.getZhName());
		data4cInfo.setPm(assembly.getLeaderName());
		ComponentInfoHelper result = new ComponentInfoHelper();
		result.setData(data4cInfo);
		result.setSuccess(true);
		return result;
	}

}
