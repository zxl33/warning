/**
 * @(#)MemberDao.java 2017年8月7日
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

import com.alarm.entity.Member;

/**
 * @author 张小莲
 * @date 2017年8月7日
 * @version $Revision$
 */
public interface MemberDao {
	//删除值班人员
	public void deleteMember(Integer id);

	//增加值班人员
	public void addMember(Member member);

	//更新值班人员信息
	public void updateMember(Member member);

	//查询某个组件的所有值班人员
	public List<Member> getMemberByAssembly(Integer assemblyID);

	//查询所有的值班人员
	public Map<Integer, String> getAllMember();

	//根据值班人员id查询值班人员
	public Member getMember(Integer id);

	//根据值班人员姓名查询值班人员
	public Member getMemberByName(String name);

}
