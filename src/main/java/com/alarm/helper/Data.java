/**
 * @(#)componentListHelper.java 2017年8月15日
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
 * 用于组件管理的返回数据格式
 * @author 张小莲
 * @date 2017年8月15日
 * @version $Revision$
 */
public class Data {
	private int count;
	private Rows[] rows;

	public Data() {
		count = 10;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Rows[] getRows() {
		return rows;
	}

	public void setRows(Rows[] rows) {
		this.rows = rows;
	}

}
