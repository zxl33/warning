/**
 * @(#)AssemblyController.java 2017年8月10日
 * 
 * Copyright 2000-2017 by ChinanetCenter Corporation.
 *
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ChinanetCenter Corporation ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with ChinanetCenter.
 * 
 */

package com.alarm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.entity.Assembly;
import com.alarm.entity.Member;
import com.alarm.helper.ComponentInfoHelper;
import com.alarm.helper.ComponentListHelper;
import com.alarm.helper.ComponentManagerListHelper;
import com.alarm.helper.Data;
import com.alarm.helper.Data4CInfo;
import com.alarm.helper.Data4List;
import com.alarm.helper.Rows;
import com.alarm.helper.Rows4List;
import com.alarm.helper.SuccessHelper;
import com.alarm.service.AssemblyService;
import com.alarm.service.DutyService;
import com.alarm.service.MessageService;
import com.alarm.service.TempService;

/**
 * @author 张小莲
 * @date 2017年8月10日
 * @version $Revision$
 */
@Controller
@RequestMapping("/assembly")
public class AssemblyController {
	@Autowired
	private AssemblyService assemblyService;
	@Autowired
	private DutyService dutyService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private TempService tempService;

	//组件查询，根据组件的姓名和组件的负责人进行模糊查询
	@RequestMapping("/assemblySearch")
	@ResponseBody
	public ComponentListHelper assemblySearch(Model model,
			@RequestParam(value = "componentName", required = false) String name,
			@RequestParam(value = "pm", required = false) String leader) {

		List<Assembly> list = assemblyService.getAssemblyByQuery(name, leader);
		Rows4List rows[] = new Rows4List[list.size()];
		List<Member> members = new ArrayList<Member>();
		Map<Integer, String> todayMembers = new HashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++) {
			rows[i] = new Rows4List();
			rows[i].setComponentName(list.get(i).getZhName());
			rows[i].setId(list.get(i).getId());
			rows[i].setPm((list.get(i).getLeaderName()));

			//查询当前值班人员，当天星期数和时间，返回值班人员的姓名
			String onDutyName = dutyService.getOnDutyNow(list.get(i).getId());
			System.out.println(onDutyName);
			rows[i].setPersonOnDuty(onDutyName);

			//查询告警量，根据组件id，查询告警量
			rows[i].setWarningValue(messageService.countMessage(list.get(i).getId()).toString());

			//获取当天的三个班次的值班人员
			todayMembers = dutyService.getOnDutyToday(list.get(i).getId());
			if (todayMembers.containsKey(1)) {
				rows[i].setNightOnDuty(todayMembers.get(1));
			}
			if (todayMembers.containsKey(2)) {
				rows[i].setMorningOnDuty(todayMembers.get(2));
			}
			if (todayMembers.containsKey(3)) {
				rows[i].setEveningOnDuty(todayMembers.get(3));
			}
			System.out.println(rows[i].toString());
		}
		Data4List data = new Data4List();
		data.setCount(100);
		data.setRows(rows);
		ComponentListHelper result = new ComponentListHelper();
		result.setData(data);
		result.setSuccess(true);
		return result;
	}

	//编辑组件的跳转
	@RequestMapping("/editorAssembly")
	public String gotoEditorAssembly(@PathVariable("componentId") Integer id) {
		return "/componentOperation";
	}

	//组件管理列表，获取全部组件管理列表，包括
	@RequestMapping("/assemblyManagerList")
	public ComponentManagerListHelper assemblyManagerList() {
		List<Assembly> list = assemblyService.getAllAssembly();
		ComponentManagerListHelper result = new ComponentManagerListHelper();
		Rows rows[] = new Rows[list.size()];
		String temp = "";
		for (int i = 0; i < list.size(); i++) {
			rows[i] = new Rows();
			//获取消息传递方式
			if (list.get(i).getMoveEmail() == 1) {
				temp += "1";
			}
			if (list.get(i).getMoveNote() == 1) {
				temp += ",2";
			}
			if (list.get(i).getMoveApp() == 1) {
				temp += ",3";
			}
			if (list.get(i).getMoveSignal() == 1) {
				temp += ",4";
			}
			rows[i].setBroadcastWays(temp);
			rows[i].setComponentChineseName(list.get(i).getZhName());
			rows[i].setComponentEnglishName(list.get(i).getEnName());
			rows[i].setEmail(list.get(i).getLeaderEmail());
			rows[i].setId(list.get(i).getId());
			rows[i].setMailTemplate(list.get(i).getEmailModelID().toString());
			rows[i].setMessageTemplate(list.get(i).getNoteModelID().toString());
			rows[i].setPm(list.get(i).getLeaderName());
			System.out.println("英文名称：" + rows[i].getComponentEnglishName());
		}
		Data data = new Data();
		data.setCount(100);
		data.setRows(rows);
		result.setData(data);
		result.setSuccess(true);

		return result;
	}

	//组件管理列表查询，模糊查询，根据组件的
	@RequestMapping("/assemblyManagerListSearch")
	@ResponseBody
	public ComponentManagerListHelper assemblyManagerListSearch(Model model,
			@RequestParam(value = "componentName", required = false) String name,
			@RequestParam(value = "pm", required = false) String leader) {
		System.out.println(name + " " + leader);
		List<Assembly> list = assemblyService.getAssemblyByQuery(name, leader);
		ComponentManagerListHelper result = new ComponentManagerListHelper();
		Rows rows[] = new Rows[list.size()];
		String temp = "";
		for (int i = 0; i < list.size(); i++) {
			rows[i] = new Rows();
			temp = "";
			//获取消息传递方式
			if (list.get(i).getMoveEmail() == 1) {
				temp += "1";
			}
			if (list.get(i).getMoveNote() == 1) {
				temp += "2";
			}
			if (list.get(i).getMoveApp() == 1) {
				temp += "3";
			}
			if (list.get(i).getMoveSignal() == 1) {
				temp += "4";
			}
			System.out.println("传送过去给你的ways" + temp);
			rows[i].setBroadcastWays(temp);
			rows[i].setComponentChineseName(list.get(i).getZhName());
			rows[i].setComponentEnglishName(list.get(i).getEnName());
			rows[i].setEmail(list.get(i).getLeaderEmail());
			rows[i].setId(list.get(i).getId());
			if (list.get(i).getEmailModelID() != null && list.get(i).getEmailModelID() != 0)
				rows[i].setMailTemplate(
						tempService.getTempByID(list.get(i).getEmailModelID()).getName());
			if (list.get(i).getNoteModelID() != null && list.get(i).getNoteModelID() != 0)
				rows[i].setMessageTemplate(
						tempService.getTempByID(list.get(i).getNoteModelID()).getName());
			rows[i].setPm(list.get(i).getLeaderName());
			System.out.println(list.get(i).getEnName());
			System.out.println(rows[i].toString());
		}
		Data data = new Data();
		data.setCount(100);
		data.setRows(rows);
		result.setData(data);
		result.setSuccess(true);

		return result;

	}

	//修改组件
	@RequestMapping("/updateAssembly")
	@ResponseBody
	public SuccessHelper updateAssembly(@RequestParam(value = "id", required = false) int id,
			@RequestParam(value = "componentChineseName", required = false) String zhname,
			@RequestParam(value = "componentEnglishName", required = false) String enname,
			@RequestParam(value = "pm", required = false) String leaderName,
			@RequestParam(value = "email", required = false) String leaderEmail,
			@RequestParam(value = "broadcastWays", required = false) String ways,
			@RequestParam(value = "mailTemplate", required = false) String mailType,
			@RequestParam(value = "messageTemplate", required = false) String messageType) {

		//先切割告警推送方式，判断是否包含以下四种推送方式
		boolean isMail = false, isApp = false, isNote = false, isSignal = false;
		if (ways != "" && ways != null) {
			isMail = ways.contains("1");
			isNote = ways.contains("2");
			isApp = ways.contains("3");
			isSignal = ways.contains("4");
		}

		Assembly assembly = new Assembly();

		//组件值注入
		assembly.setId(id);
		assembly.setZhName(zhname);
		assembly.setEnName(enname);
		assembly.setLeaderEmail(leaderEmail);
		assembly.setLeaderName(leaderName);
		if (isApp) {
			assembly.setMoveApp(1);
		}
		else {
			assembly.setMoveApp(0);
		}
		if (isNote) {
			assembly.setMoveNote(1);
		}
		else {
			assembly.setMoveNote(0);
		}
		if (isMail) {
			assembly.setMoveEmail(1);
		}
		else {
			assembly.setMoveEmail(0);
		}
		if (isSignal) {
			assembly.setMoveSignal(1);
		}
		else {
			assembly.setMoveSignal(0);
		}
		if (mailType == "" || mailType == null)
			assembly.setEmailModelID(0);
		else
			assembly.setEmailModelID(tempService.getTempByName(mailType).getTemp_id());
		if (messageType == "" || messageType == null)
			assembly.setNoteModelID(0);
		else
			assembly.setNoteModelID(tempService.getTempByName(messageType).getTemp_id());
		int code = assemblyService.updateAssembly(assembly);
		SuccessHelper result = new SuccessHelper();
		result.setCode(code);
		if (code == 0)
			result.setSuccess(true);
		else
			result.setSuccess(false);

		return result;
	}

	//增加组件
	@RequestMapping("/addAssembly")
	@ResponseBody
	public SuccessHelper addAssembly(Model model,
			@RequestParam(value = "componentChineseName", required = false) String zhname,
			@RequestParam(value = "componentEnglishName", required = false) String enname,
			@RequestParam(value = "pm", required = false) String leaderName,
			@RequestParam(value = "email", required = false) String leaderEmail,
			@RequestParam(value = "broadcastWays", required = false) String ways,
			@RequestParam(value = "mailTemplate", required = false) String mailType,
			@RequestParam(value = "messageTemplate", required = false) String messageType) {

		//先切割告警推送方式，判断是否包含以下四种推送方式
		boolean isMail = false, isApp = false, isNote = false, isSignal = false;
		if (ways != "" && ways != null) {
			isMail = ways.contains("1");
			isNote = ways.contains("2");
			isApp = ways.contains("3");
			isSignal = ways.contains("4");
		}

		Assembly assembly = new Assembly();

		//组件值注入
		assembly.setId(null);
		assembly.setZhName(zhname);
		assembly.setEnName(enname);
		assembly.setLeaderEmail(leaderEmail);
		assembly.setLeaderName(leaderName);
		if (isApp) {
			assembly.setMoveApp(1);
		}
		else {
			assembly.setMoveApp(0);
		}
		if (isNote) {
			assembly.setMoveNote(1);
		}
		else {
			assembly.setMoveNote(0);
		}
		if (isMail) {
			assembly.setMoveEmail(1);
		}
		else {
			assembly.setMoveEmail(0);
		}
		if (isSignal) {
			assembly.setMoveSignal(1);
		}
		else {
			assembly.setMoveSignal(0);
		}
		if (mailType == "" || mailType == null)
			assembly.setEmailModelID(0);
		else
			assembly.setEmailModelID(tempService.getTempByName(mailType).getTemp_id());
		if (messageType == "" || messageType == null)
			assembly.setNoteModelID(0);
		else
			assembly.setNoteModelID(tempService.getTempByName(messageType).getTemp_id());
		int code = assemblyService.addAssembly(assembly);
		SuccessHelper result = new SuccessHelper();
		result.setCode(code);
		if (code == 0)
			result.setSuccess(true);
		else
			result.setSuccess(false);

		return result;
	}

	//删除组件
	@RequestMapping("/deleteAssembly")
	@ResponseBody
	public SuccessHelper deleteAssembly(Model model,
			@RequestParam(value = "id", required = false) int id) {
		Assembly assembly = new Assembly();
		assembly.setId(id);
		assemblyService.deleteAssembly(assembly);
		SuccessHelper result = new SuccessHelper();
		result.setSuccess(true);
		return result;
	}

	@RequestMapping("/getNameAndLeader")
	@ResponseBody
	public ComponentInfoHelper getNameAndLeaderByID(
			@RequestParam(value = "id", required = false) int id) {
		System.out.println("###" + id + "###");
		Assembly assembly = assemblyService.getAssemblyByOne(id);
		Data4CInfo data4cInfo = new Data4CInfo();
		data4cInfo.setComponentInfo(assembly.getZhName());
		data4cInfo.setPm(assembly.getLeaderName());
		ComponentInfoHelper result = new ComponentInfoHelper();
		result.setData(data4cInfo);
		result.setSuccess(true);
		return result;
	}

	//点击“编辑组件”，跳转到组件操作页面，传递id
	@RequestMapping("/gotoCO")
	public String gotoComponentOperation() {
		return "componentOperation";
	}

}
