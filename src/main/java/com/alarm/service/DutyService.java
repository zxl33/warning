/**
 * @(#)DutyService.java 2017年8月9日
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

package com.alarm.service;

import java.util.List;
import java.util.Map;

import com.alarm.entity.Duty;

/**
 * @author 张小莲
 * @date 2017年8月9日
 * @version $Revision$
 */
public interface DutyService {
	//查询当时值班人员
	public String getOnDutyNow(Integer assemblyID);

	//查询当天值班人员
	public Map<Integer, String> getOnDutyToday(Integer assemblyID);

	//查询值班表
	public List<Duty> getAllDuty(Integer assemblyID);

	//修改值班表
	public void resetDutyByID(Integer id, Integer newMemberId);

	//根据组件id+新修改后的值班人员姓名，更新当天值班表
	public void updateTodayDuty(Integer assemblyID, String nightName, String morningName,
			String eveningName);

	//保存或修改具体某个时刻的值班表中一个人
	public void saveOrUpdateDutyOnTable(Integer assemblyID, Integer newMemberID, Integer timeType,
			Integer weekday);

}
