/**
 * @(#)Rows4List.java 2017年8月16日
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

package com.alarm.helper;

/**
 * @author 张小莲
 * @date 2017年8月16日
 * @version $Revision$
 */
public class Rows4List {
	private int id;
	private String componentName;
	private String pm;
	private String personOnDuty;//当前值班人员
	private String warningValue;//告警量，根据组件的id查询
	// 下面三项可以为空
	private String nightOnDuty;
	private String morningOnDuty;
	private String eveningOnDuty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getPersonOnDuty() {
		return personOnDuty;
	}

	public void setPersonOnDuty(String personOnDuty) {
		this.personOnDuty = personOnDuty;
	}

	public String getWarningValue() {
		return warningValue;
	}

	public void setWarningValue(String warningValue) {
		this.warningValue = warningValue;
	}

	public String getNightOnDuty() {
		return nightOnDuty;
	}

	public void setNightOnDuty(String nightOnDuty) {
		this.nightOnDuty = nightOnDuty;
	}

	public String getMorningOnDuty() {
		return morningOnDuty;
	}

	public void setMorningOnDuty(String morningOnDuty) {
		this.morningOnDuty = morningOnDuty;
	}

	public String getEveningOnDuty() {
		return eveningOnDuty;
	}

	public void setEveningOnDuty(String eveningOnDuty) {
		this.eveningOnDuty = eveningOnDuty;
	}

}
