/**
 * @(#)Rows.java 2017年8月16日
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
 * 用于组件管理返回的对象类型
 * @author 张小莲
 * @date 2017年8月16日
 * @version $Revision$
 */
public class Rows {
	private int id;
	private String componentChineseName;
	private String componentEnglishName;
	private String pm;
	private String email;
	private String broadcastWays;//1-4依次表示邮件、短信、APP、公众号
	// 下面两项可以为空
	private String mailTemplate;
	private String messageTemplate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComponentChineseName() {
		return componentChineseName;
	}

	public void setComponentChineseName(String componentChineseName) {
		this.componentChineseName = componentChineseName;
	}

	public String getComponentEnglishName() {
		return componentEnglishName;
	}

	public void setComponentEnglishName(String componentEnglishName) {
		this.componentEnglishName = componentEnglishName;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBroadcastWays() {
		return broadcastWays;
	}

	public void setBroadcastWays(String broadcastWays) {
		this.broadcastWays = broadcastWays;
	}

	public String getMailTemplate() {
		return mailTemplate;
	}

	public void setMailTemplate(String mailTemplate) {
		this.mailTemplate = mailTemplate;
	}

	public String getMessageTemplate() {
		return messageTemplate;
	}

	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = messageTemplate;
	}

}
