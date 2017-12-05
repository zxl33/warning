/**
 * @(#)DutyServiceImpl.java 2017年8月9日
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

package com.alarm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alarm.dao.DutyDao;
import com.alarm.dao.MemberDao;
import com.alarm.entity.Duty;
import com.alarm.entity.Member;
import com.alarm.service.DutyService;

/**
 * @author 张小莲
 * @date 2017年8月9日
 * @version $Revision$
 */
@Service
public class DutyServiceImpl implements DutyService {
	@Autowired
	private DutyDao dutydao;
	@Autowired
	private MemberDao memberDao;

	//查询当天的所有值班人员,返回当天值班的所有人

	public String getOnDutyNow(Integer assemblyID) {
		String result = dutydao.getDutyByNow(assemblyID);
		return result;

	}

	//查询当天值班人员
	public Map<Integer, String> getOnDutyToday(Integer assemblyID) {
		return dutydao.getDutyByToday(assemblyID);
	}

	//查询值班表
	public List<Duty> getAllDuty(Integer assemblyID) {
		List<Duty> list = dutydao.getDuty(assemblyID);
		return list;
	}

	//修改值班表
	public void resetDutyByID(Integer id, Integer newMemberId) {
		dutydao.saveOrUpdateDuty(id, newMemberId, 1);
	}

	//根据组件id+新修改后的值班人员姓名，更新当天值班表
	public void updateTodayDuty(Integer assemblyID, String nightName, String morningName,
			String eveningName) {
		//依次更新每个班次的值班表
		System.out.println(
				"@@@@:" + assemblyID + "  " + nightName + " " + morningName + " " + eveningName);
		//先执行有memberName查询member
		Member member1 = memberDao.getMemberByName(nightName);
		System.out.println("值班人员1的id等于" + member1.getId());
		//再根据值班人员的值班信息
		if (member1 != null) {
			dutydao.saveOrUpdateDuty(assemblyID, member1.getId(), 1);
		}
		Member member2 = memberDao.getMemberByName(morningName);
		System.out.println("值班人员2的id等于" + member2.getId());
		//再根据值班人员的值班信息
		if (member2 != null) {
			dutydao.saveOrUpdateDuty(assemblyID, member2.getId(), 2);
		}
		Member member3 = memberDao.getMemberByName(eveningName);
		System.out.println("值班人员3的id等于" + member3.getId());
		//再根据值班人员的值班信息
		if (member3 != null) {
			dutydao.saveOrUpdateDuty(assemblyID, member3.getId(), 3);
		}
	}

	//保存或修改具体某个时刻的值班表中一个人
	public void saveOrUpdateDutyOnTable(Integer assemblyID, Integer newMemberID, Integer timeType,
			Integer weekday) {
		dutydao.saveOrUpdateDutyOnTable(assemblyID, newMemberID, timeType, weekday);
	}

}
