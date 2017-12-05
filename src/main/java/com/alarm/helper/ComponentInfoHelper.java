/**
 * @(#)ComponentInfoHelper.java 2017年8月17日
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
public class ComponentInfoHelper {
	private boolean success;
	private Data4CInfo data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Data4CInfo getData() {
		return data;
	}

	public void setData(Data4CInfo data) {
		this.data = data;
	}

}
