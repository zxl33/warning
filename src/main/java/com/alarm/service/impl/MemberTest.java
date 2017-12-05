/**
 * @(#)MemberTest.java 2017年8月14日
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

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alarm.entity.Member;

/**
 * @author 张小莲
 * @date 2017年8月14日
 * @version $Revision$
 */
public class MemberTest {
	@Autowired
	private MemberServiceImpl memberS = new MemberServiceImpl();

	/**
	 * Test method for {@link com.alarm.service.impl.MemberServiceImpl#getMembers(java.lang.Integer)}.
	 */
	@Test
	public void testGetMembers() {
		//String string = memberS.getMembers(1).toString();
		//System.out.println(string);

	}

	/**
	 * Test method for {@link com.alarm.service.impl.MemberServiceImpl#addMember(com.alarm.entity.Member)}.
	 */
	@Test
	public void testAddMember() {
		Member member = new Member();
		member.setAssemblyID(1);
		member.setMemberEmail("43464557@163.com");
		member.setMemberName("值班人员3");
		memberS.addMember(member);

	}

	/**
	 * Test method for {@link com.alarm.service.impl.MemberServiceImpl#deleteMember(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteMember() {

	}

}
