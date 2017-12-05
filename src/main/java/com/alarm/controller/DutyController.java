/**
 * @(#)DutyController.java 2017年8月10日
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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.entity.Duty;
import com.alarm.helper.Data4Duty;
import com.alarm.helper.DutyHelper;
import com.alarm.helper.Rows4Duty;
import com.alarm.helper.SuccessHelper;
import com.alarm.service.DutyService;
import com.alarm.service.MemberService;

/**
 * @author 张小莲
 * @date 2017年8月10日
 * @version $Revision$
 */
@Controller
public class DutyController {
	@Autowired
	private DutyService dutyService;
	@Autowired
	private MemberService memberService;

	//查询组件的值班人员
	@RequestMapping("demo/simple/componentEdit/getDutiesByID")
	@ResponseBody
	public DutyHelper getDuties(@RequestParam(value = "id", required = false) int id) {
		System.out.println("@@@@@获取到响应了啦啦啦");
		List<Duty> list = dutyService.getAllDuty(id);
		Rows4Duty rows[] = new Rows4Duty[3];//第一班时的
		rows[0] = new Rows4Duty();
		rows[0].setTimeType(1);
		rows[1] = new Rows4Duty();
		rows[1].setTimeType(2);
		rows[2] = new Rows4Duty();
		rows[2].setTimeType(3);
		if (list.size() > 0) {
			Integer week;
			int timeType;
			for (int i = 0; i < list.size(); i++) {
				week = list.get(i).getWeek();
				timeType = list.get(i).getTimeType();
				rows[timeType - 1].setDay(week, list.get(i).getMemberID());
			}

		}
		Data4Duty data4Duty = new Data4Duty();
		data4Duty.setCount(10);
		data4Duty.setRows(rows);
		DutyHelper result = new DutyHelper();
		result.setData(data4Duty);
		result.setSuccess(true);
		return result;
	}

	//保存改组件的当天值班人员，传参有组件id，三个值班人员的名字
	@RequestMapping("/testList/duty/updateDutyToday")
	@ResponseBody
	public SuccessHelper updateTodayDuty(@RequestParam(value = "id", required = false) int id,
			@RequestParam(value = "nightOnDuty", required = false) String night,
			@RequestParam(value = "morningOnDuty", required = false) String morning,
			@RequestParam(value = "eveningOnDuty", required = false) String evening) {
		SuccessHelper result = new SuccessHelper();
		dutyService.updateTodayDuty(id, night, morning, evening);
		result.setSuccess(true);
		return result;

	}

	//保存值班表
	@RequestMapping("demo/simple/componentEdit/updateDuty")
	@ResponseBody
	public SuccessHelper updateDuty(@RequestParam(value = "id", required = false) int id,
			@RequestParam(value = "data[0][day1]", required = false) int memberId11,
			@RequestParam(value = "data[0][day2]", required = false) int memberId12,
			@RequestParam(value = "data[0][day3]", required = false) int memberId13,
			@RequestParam(value = "data[0][day4]", required = false) int memberId14,
			@RequestParam(value = "data[0][day5]", required = false) int memberId15,
			@RequestParam(value = "data[0][day6]", required = false) int memberId16,
			@RequestParam(value = "data[0][day7]", required = false) int memberId17,
			@RequestParam(value = "data[1][day1]", required = false) int memberId21,
			@RequestParam(value = "data[1][day2]", required = false) int memberId22,
			@RequestParam(value = "data[1][day3]", required = false) int memberId23,
			@RequestParam(value = "data[1][day4]", required = false) int memberId24,
			@RequestParam(value = "data[1][day5]", required = false) int memberId25,
			@RequestParam(value = "data[1][day6]", required = false) int memberId26,
			@RequestParam(value = "data[1][day7]", required = false) int memberId27,
			@RequestParam(value = "data[2][day1]", required = false) int memberId31,
			@RequestParam(value = "data[2][day2]", required = false) int memberId32,
			@RequestParam(value = "data[2][day3]", required = false) int memberId33,
			@RequestParam(value = "data[2][day4]", required = false) int memberId34,
			@RequestParam(value = "data[2][day5]", required = false) int memberId35,
			@RequestParam(value = "data[2][day6]", required = false) int memberId36,
			@RequestParam(value = "data[2][day7]", required = false) int memberId37) {
		System.out.println("id==" + id);
		System.out.println("data==" + memberId16);
		dutyService.saveOrUpdateDutyOnTable(id, memberId11, 1, 1);
		dutyService.saveOrUpdateDutyOnTable(id, memberId12, 1, 2);
		dutyService.saveOrUpdateDutyOnTable(id, memberId13, 1, 3);
		dutyService.saveOrUpdateDutyOnTable(id, memberId14, 1, 4);
		dutyService.saveOrUpdateDutyOnTable(id, memberId15, 1, 5);
		dutyService.saveOrUpdateDutyOnTable(id, memberId16, 1, 6);
		dutyService.saveOrUpdateDutyOnTable(id, memberId17, 1, 7);
		dutyService.saveOrUpdateDutyOnTable(id, memberId21, 2, 1);
		dutyService.saveOrUpdateDutyOnTable(id, memberId22, 2, 2);
		dutyService.saveOrUpdateDutyOnTable(id, memberId23, 2, 3);
		dutyService.saveOrUpdateDutyOnTable(id, memberId24, 2, 4);
		dutyService.saveOrUpdateDutyOnTable(id, memberId25, 2, 5);
		dutyService.saveOrUpdateDutyOnTable(id, memberId26, 2, 6);
		dutyService.saveOrUpdateDutyOnTable(id, memberId27, 2, 7);
		dutyService.saveOrUpdateDutyOnTable(id, memberId31, 3, 1);
		dutyService.saveOrUpdateDutyOnTable(id, memberId32, 3, 2);
		dutyService.saveOrUpdateDutyOnTable(id, memberId33, 3, 3);
		dutyService.saveOrUpdateDutyOnTable(id, memberId34, 3, 4);
		dutyService.saveOrUpdateDutyOnTable(id, memberId35, 3, 5);
		dutyService.saveOrUpdateDutyOnTable(id, memberId36, 3, 6);
		dutyService.saveOrUpdateDutyOnTable(id, memberId37, 3, 7);
		SuccessHelper result = new SuccessHelper();
		result.setSuccess(true);
		return result;
	}
}
