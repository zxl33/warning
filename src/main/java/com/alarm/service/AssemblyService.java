/**
 * @(#)AssemblyService.java 2017年8月9日
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

import com.alarm.entity.Assembly;

/**
 * @author 张小莲
 * @date 2017年8月9日
 * @version $Revision$
 */
public interface AssemblyService {
	//查询所有的组件
	public List<Assembly> getAllAssembly();

	//根据组件名和组件负责人查询组件
	public List<Assembly> getAssemblyByQuery(String assemblyName, String leaderName);

	//查询具体组件
	public Assembly getAssemblyByOne(Integer id);

	//新增组件
	public int addAssembly(Assembly assembly);

	//修改组件
	public int updateAssembly(Assembly assembly);

	//删除组件
	public void deleteAssembly(Assembly assembly);

	//根据组件名查询组件Id
	public List<Integer> getAssemblyIDByName(String name);

	//根据组件id查询组件名,如果查询不到，则返回""。
	public String getAssemblyNameByID(Integer id);

}
