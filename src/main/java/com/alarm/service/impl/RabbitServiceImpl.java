/**
 * @(#)RabbitServiceImpl.java 2017年11月17日
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

package com.alarm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alarm.dao.impl.RabbitDaoImpl;
import com.alarm.entity.Record;

/**
 * @author 张小莲
 * @date 2017年11月17日
 * @version $Revision$
 */
@Service
public class RabbitServiceImpl {
	@Autowired
	public RabbitDaoImpl rabbitDao;

	public List<Record> getRecords(String queue) {
		return rabbitDao.getRecords(queue);
	}

	//传进来的数据格式：{ "text":"测试测试","color":"#ffffff","size":"1","position":"0","time":272}
	public void addRecord(String newRecord, String queue) {

		Record record = new Record();
		record.setId(null);
		record.setMessage(newRecord);
		record.setQueue(queue);
		Date date = new Date();
		record.setTime(date);
		rabbitDao.addRecord(record);
	}

}
