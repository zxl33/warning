/**
 * @(#)Data4Duty.java 2017年8月17日
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
public class Data4Duty {
	private int count;
	private Rows4Duty[] rows;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Rows4Duty[] getRows() {
		return rows;
	}

	public void setRows(Rows4Duty[] rows) {
		this.rows = rows;
	}

}
