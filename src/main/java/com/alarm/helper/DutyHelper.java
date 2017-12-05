/**
 * @(#)DutyHelper.java 2017年8月17日
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
 * @date 2017年8月17日
 * @version $Revision$
 */
public class DutyHelper {
	private boolean success;
	private Data4Duty data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Data4Duty getData() {
		return data;
	}

	public void setData(Data4Duty data) {
		this.data = data;
	}

}
