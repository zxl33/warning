/**
 * @(#)DutyDao.java 2017年8月7日
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

package com.alarm.dao;

import java.util.List;
import java.util.Map;

import com.alarm.entity.Duty;

/**
 * @author 张小莲
 * @date 2017年8月7日
 * @version $Revision$
 */
public interface DutyDao {
	//查询某个组件的值班表
	public List<Duty> getDuty(Integer assemblyID);

	//查询某个组件现在这个时刻的值班人员姓名，当前时间以系统为准
	public String getDutyByNow(Integer assemblyID);

	//查询某个组件当天的值班人员姓名，当前时间以系统为准
	public Map<Integer, String> getDutyByToday(Integer assemblyID);

	//保存或修改具体某时刻的值班人员
	public void saveOrUpdateDuty(Integer id, Integer newID, Integer timeType);

	//保存或修改具体某个时刻的值班表中一个人
	public void saveOrUpdateDutyOnTable(Integer assemblyID, Integer newMemberID, Integer timeType,
			Integer weekday);
}
