/**
 * @(#)AssemblyDao.java 2017年8月7日
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

import com.alarm.entity.Assembly;

/**
 * @author 张小莲
 * @date 2017年8月7日
 * @version $Revision$
 */
public interface AssemblyDao {
	//组件查询
	public List<Assembly> getAllAssembly();

	//根据组件Id查询具体的组件
	public Assembly getAssemblyById(Integer id);

	//根据组件名查询组件Id
	public List<Integer> getAssemblyIDByName(String name);

	//根据组件名和组件负责人查询
	public List<Assembly> getAssemblyByNameAndLeader(String name, String leader);

	//增加组件
	public void addAssembly(Assembly assembly);

	//修改组件
	public void updateAssembly(Assembly assembly);

	//删除组件
	public void deleteAssembly(Assembly assembly);

}
