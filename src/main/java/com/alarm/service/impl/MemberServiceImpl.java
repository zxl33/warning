/**
 * @(#)MemberServiceImpl.java 2017年8月10日
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

import com.alarm.dao.MemberDao;
import com.alarm.entity.Member;
import com.alarm.service.MemberService;

/**
 * @author 张小莲
 * @date 2017年8月10日
 * @version $Revision$
 */
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	//查询某个组件的所有值班人员
	public List<Member> getMembers(Integer assemblyID) {
		List<Member> list = memberDao.getMemberByAssembly(assemblyID);
		return list;

	}

	//新增组件的值班人员
	public void addMember(Member member) {
		memberDao.addMember(member);
		return;

	}

	//删除组件的值班人员
	public void deleteMember(Integer id) {
		memberDao.deleteMember(id);
		return;

	}

}
