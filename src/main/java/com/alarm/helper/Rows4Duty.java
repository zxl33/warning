/**
 * @(#)Rows4Duty.java 2017年8月17日
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
public class Rows4Duty {
	private Integer timeType;//值班类型，1：0-8点，2：8-16点，3：16-24点
	private Integer day1;
	private Integer day2;
	private Integer day3;
	private Integer day4;
	private Integer day5;
	private Integer day6;
	private Integer day7;

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public Integer getDay1() {
		return day1;
	}

	public void setDay1(Integer day1) {
		this.day1 = day1;
	}

	public Integer getDay2() {
		return day2;
	}

	public void setDay2(Integer day2) {
		this.day2 = day2;
	}

	public Integer getDay3() {
		return day3;
	}

	public void setDay3(Integer day3) {
		this.day3 = day3;
	}

	public Integer getDay4() {
		return day4;
	}

	public void setDay4(Integer day4) {
		this.day4 = day4;
	}

	public Integer getDay5() {
		return day5;
	}

	public void setDay5(Integer day5) {
		this.day5 = day5;
	}

	public Integer getDay6() {
		return day6;
	}

	public void setDay6(Integer day6) {
		this.day6 = day6;
	}

	public Integer getDay7() {
		return day7;
	}

	public void setDay7(Integer day7) {
		this.day7 = day7;
	}

	public void setDay(Integer week, Integer memberId) {
		if (week == 1) {
			setDay1(memberId);
		}
		else if (week == 2) {
			setDay2(memberId);
		}
		else if (week == 3) {
			setDay3(memberId);
		}
		else if (week == 4) {
			setDay4(memberId);
		}
		else if (week == 5) {
			setDay5(memberId);
		}
		else if (week == 6) {
			setDay6(memberId);
		}
		else {
			setDay7(memberId);
		}
	}

}
