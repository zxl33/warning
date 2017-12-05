/**
 * @(#)MemberService.java 2017年8月9日
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

import com.alarm.entity.Member;

/**
 * @author 张小莲
 * @date 2017年8月9日
 * @version $Revision$
 */
public interface MemberService {
	//查询某个组件的所有值班人员
	public List<Member> getMembers(Integer assemblyID);

	//新增组件的值班人员
	public void addMember(Member member);

	//删除组件的值班人员
	public void deleteMember(Integer id);

}
