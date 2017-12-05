/**
 * @(#)Result.java 2017年8月19日
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
public class Data4DutySearch {
	Map<String, String> personsOnDuty;

	public Map<String, String> getPersonsOnDuty() {
		return personsOnDuty;
	}

	public void setPersonsOnDuty(Map<String, String> personsOnDuty) {
		this.personsOnDuty = personsOnDuty;
	}

}
