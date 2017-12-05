/**
 * @(#)MemberController.java 2017年8月10日
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.entity.Member;
import com.alarm.helper.Data4DutySearch;
import com.alarm.helper.Data4Member;
import com.alarm.helper.Data4MemberSearch;
import com.alarm.helper.DutySearchHelper;
import com.alarm.helper.MemberHelper;
import com.alarm.helper.MemberSearchHelper;
import com.alarm.helper.Rows4Member;
import com.alarm.helper.SuccessHelper;
import com.alarm.service.MemberService;

/**
 * @author 张小莲
 * @date 2017年8月10日
 * @version $Revision$
 */
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	//增加值班人员
	@RequestMapping("demo/simple/componentEdit/addMember")
	@ResponseBody
	public SuccessHelper addMember(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "assemblyId", required = false) int assemblyId) {
		Member member = new Member();
		member.setId(null);
		member.setAssemblyID(assemblyId);
		member.setMemberName(name);
		member.setMemberEmail(email);
		memberService.addMember(member);
		SuccessHelper result = new SuccessHelper();
		result.setSuccess(true);
		return result;
	}

	//查询组件id对应的所有值班人员
	@RequestMapping("demo/simple/componentEdit/searchMember")
	@ResponseBody
	public MemberHelper getMember(
			@RequestParam(value = "assemblyId", required = false) int assemblyId) {
		List<Member> list = memberService.getMembers(assemblyId);
		Rows4Member rows[] = new Rows4Member[list.size()];
		for (int i = 0; i < list.size(); i++) {
			rows[i] = new Rows4Member();
			rows[i].setId(list.get(i).getId());
			rows[i].setName((list.get(i).getMemberName()));
			rows[i].setEmail(list.get(i).getMemberEmail());
		}
		Data4Member data4Member = new Data4Member();
		data4Member.setCount(10);
		data4Member.setRows(rows);
		MemberHelper result = new MemberHelper();
		result.setSuccess(true);
		result.setData(data4Member);
		return result;
	}

	//删除值班人员
	@RequestMapping("demo/simple/componentEdit/deleteMember")
	@ResponseBody
	public SuccessHelper deleteMember(@RequestParam(value = "id", required = false) int id) {
		memberService.deleteMember(id);
		SuccessHelper result = new SuccessHelper();
		result.setSuccess(true);
		return result;
	}

	//值班表内搜索值班人员，返回值班人员
	@RequestMapping("demo/simple/componentEdit/selectMemberByID")
	@ResponseBody
	public DutySearchHelper selectMemberByID(@RequestParam(value = "id", required = false) int id) {
		List<Member> list = memberService.getMembers(id);
		DutySearchHelper helper = new DutySearchHelper();
		Data4DutySearch data = new Data4DutySearch();
		Map<String, String> result = new HashMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			result.put(list.get(i).getId().toString(), list.get(i).getMemberName());
		}
		data.setPersonsOnDuty(result);
		helper.setData(data);
		helper.setSuccess(true);
		return helper;
	}

	//修改值班人员时搜索值班人员，返回值班人员
	@RequestMapping("demo/simple/componentEdit/selectMemberByID2")
	@ResponseBody
	public MemberSearchHelper selectMemberByID2(
			@RequestParam(value = "id", required = false) int id) {
		List<Member> list = memberService.getMembers(id);
		MemberSearchHelper helper = new MemberSearchHelper();
		Data4MemberSearch data = new Data4MemberSearch();
		Map<String, Object> result = new HashMap<String, Object>();
		for (int i = 0; i < list.size(); i++) {
			com.alarm.helper.Label label = new com.alarm.helper.Label();
			label.setLabel(list.get(i).getMemberName());
			result.put(list.get(i).getMemberName(), label);
		}
		data.setSelectorData(result);
		data.setTotal(list.size());
		helper.setData(data);
		helper.setSuccess(true);
		return helper;
	}

}
