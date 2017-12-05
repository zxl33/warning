/**
 * @(#)MemberSearchHelper.java 2017年8月19日
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
 * @date 2017年8月19日
 * @version $Revision$
 */
public class MemberSearchHelper {
	private boolean success;
	private Data4MemberSearch data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Data4MemberSearch getData() {
		return data;
	}

	public void setData(Data4MemberSearch data) {
		this.data = data;
	}

}
