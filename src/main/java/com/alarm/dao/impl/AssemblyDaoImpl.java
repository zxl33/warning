/**
 * @(#)AssemblyDaoImpl.java 2017年8月9日
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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alarm.dao.AssemblyDao;
import com.alarm.entity.Assembly;

/**
 * 组件表的增删改查
 *
 * @author 张小莲
 * @date 2017年8月9日
 * @version $Revision$
 */
@Repository
public class AssemblyDaoImpl implements AssemblyDao {
	@Autowired
	private SessionFactory sessionFactory;

	//组件查询
	public List<Assembly> getAllAssembly() {
		List<Assembly> list = (List<Assembly>) sessionFactory.getCurrentSession()
				.createQuery("from Assembly").list();
		return list;
	}

	//根据组件Id查询具体的组件
	public Assembly getAssemblyById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Assembly where id=?");
		query.setInteger(0, id);
		Assembly assembly = (Assembly) query.list().get(0);
		return assembly;
	}

	//根据组件名和组件负责人查询
	public List<Assembly> getAssemblyByNameAndLeader(String name, String leader) {
		String hql;
		hql = "from Assembly where zhName like '%" + name + "%' and leaderName like '%" + leader
				+ "%'";
		System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//query.setString(0, name);
		//query.setString(1, leader);
		List<Assembly> list = query.list();
		return list;
	}

	//增加组件
	public void addAssembly(Assembly assembly) {
		//	org.hibernate.Session session = sessionFactory.openSession();
		//	org.hibernate.Transaction tx = session.beginTransaction();
		//	session.save(assembly);
		sessionFactory.getCurrentSession().save(assembly);
		//	tx.commit();
	}

	//修改组件
	public void updateAssembly(Assembly assembly) {
		org.hibernate.Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(assembly);
		tx.commit();
	}

	//删除组件
	public void deleteAssembly(Assembly assembly) {
		org.hibernate.Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.delete(assembly);
		tx.commit();
	}

	//根据组件名查询组件Id
	public List<Integer> getAssemblyIDByName(String name) {
		String hql;
		List<Integer> list = new ArrayList<Integer>();
		if (name != "" && name != null) {
			hql = "select a.id from Assembly as a where a.zhName like '%" + name + "%'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		}
		return list;
	}

}
