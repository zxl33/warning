/**
 * @(#)AssemblyServiceImpl.java 2017年8月10日
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alarm.dao.AssemblyDao;
import com.alarm.entity.Assembly;
import com.alarm.service.AssemblyService;

/**
 * @author 张小莲
 * @date 2017年8月10日
 * @version $Revision$
 */
@Service
public class AssemblyServiceImpl implements AssemblyService {
	@Autowired
	private AssemblyDao assemblyDao;

	//查询所有的组件
	public List<Assembly> getAllAssembly() {
		List<Assembly> list = assemblyDao.getAllAssembly();
		return list;

	}

	//根据组件名和组件负责人查询组件
	public List<Assembly> getAssemblyByQuery(String assemblyName, String leaderName) {
		List<Assembly> list = assemblyDao.getAssemblyByNameAndLeader(assemblyName, leaderName);
		return list;
	}

	//查询具体组件
	public Assembly getAssemblyByOne(Integer id) {
		Assembly assembly = assemblyDao.getAssemblyById(id);
		return assembly;
	}

	//新增组件
	//返回码：0-成功新增文件，1-组件中文名为空，2-组件负责人为空,3-组件负责人邮箱为空，4-组件名称重复
	public int addAssembly(Assembly assembly) {
		int code = 0;
		if (assembly.getZhName() == "" || assembly.getZhName() == null)
			code = 1;
		else if (assembly.getLeaderName() == "" || assembly.getLeaderName() == null)
			code = 2;
		else if (assembly.getLeaderEmail() == "" || assembly.getLeaderEmail() == null)
			code = 3;
		else
			assemblyDao.addAssembly(assembly);
		return code;

	}

	//修改组件
	public int updateAssembly(Assembly assembly) {
		int code = 0;
		if (assembly.getZhName() == "" || assembly.getZhName() == null)
			code = 1;
		else if (assembly.getLeaderName() == "" || assembly.getLeaderName() == null)
			code = 2;
		else if (assembly.getLeaderEmail() == "" || assembly.getLeaderEmail() == null)
			code = 3;
		else
			assemblyDao.updateAssembly(assembly);
		return code;

	}

	//删除组件getAssemblyNameByID
	public void deleteAssembly(Assembly assembly) {
		assemblyDao.deleteAssembly(assembly);
		return;
	}

	//根据组件名查询组件Id
	public List<Integer> getAssemblyIDByName(String name) {
		return assemblyDao.getAssemblyIDByName(name);
	}

	//根据组件id查询组件名,如果查询不到，则返回""。
	public String getAssemblyNameByID(Integer id) {
		return assemblyDao.getAssemblyById(id).getZhName();
	}

}
