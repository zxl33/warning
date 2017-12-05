/**
 * @(#)RabbitDaoImpl.java 2017年11月17日
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

package com.alarm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alarm.entity.Record;

/**
 * @author 张小莲
 * @date 2017年11月17日
 * @version $Revision$
 */
@Repository
public class RabbitDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Record> getRecords(String queue) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Record where queue=?");
		query.setString(0, queue);
		List<Record> list = query.list();
		return list;
	}

	public void addRecord(Record record) {
		sessionFactory.getCurrentSession().save(record);
	}

}
