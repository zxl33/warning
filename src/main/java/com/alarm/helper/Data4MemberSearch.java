/**
 * @(#)Data4MemberSearch.java 2017年8月19日
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

import java.util.Map;

/**
 * @author 张小莲
 * @date 2017年8月19日
 * @version $Revision$
 */
public class Data4MemberSearch {
	private Map<String, Object> selectorData;
	private int total;

	public Map<String, Object> getSelectorData() {
		return selectorData;
	}

	public void setSelectorData(Map<String, Object> selectorData) {
		this.selectorData = selectorData;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
