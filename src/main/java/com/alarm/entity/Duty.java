/**
 * @(#)Duty.java 2017年8月7日
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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 张小莲
 * @date 2017年8月7日
 * @version $Revision$
 */
@Entity
@Table(name = "duty")
public class Duty {
	private Integer id;
	private Integer assemblyID;
	private Integer memberID;
	private Integer week;
	private Integer timeType;

	@Id
	@Column(name = "duty_id", unique = true, nullable = false)
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

	@Column(name = "member_id")
	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	@Column(name = "week")
	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	@Column(name = "time_type")
	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

}
