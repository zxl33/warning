/**
 * @(#)Member.java 2017年8月7日
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

package com.alarm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 张小莲
 * @date 2017年8月7日
 * @version $Revision$
 */
@Entity
@Table(name = "member")
public class Member {
	private Integer id;
	private Integer assemblyID;
	private String memberName;
	private String memberEmail;

	@Id
	@Column(name = "member_id", unique = true, nullable = false)
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "assembly_id")
	public Integer getAssemblyID() {
		return assemblyID;
	}

	public void setAssemblyID(Integer assemblyID) {
		this.assemblyID = assemblyID;
	}

	@Column(name = "member_name")
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name = "member_email")
	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

}
