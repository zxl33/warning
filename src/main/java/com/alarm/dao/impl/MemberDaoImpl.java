/**
 * @(#)MemberDaoImpl.java 2017年8月7日
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alarm.dao.MemberDao;
import com.alarm.entity.Member;

/**
 * @author 张小莲
 * @date 2017年8月7日
 * @version $Revision$
 */
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;

	//删除值班人员
	public void deleteMember(Integer id) {
		org.hibernate.Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Member member = new Member();
		member.setId(id);
		session.delete(member);
		tx.commit();
	}

	//增加值班人员
	public void addMember(Member member) {

		sessionFactory.getCurrentSession().save(member);

	}

	//更新值班人员信息
	public void updateMember(Member member) {
		sessionFactory.getCurrentSession().update(member);

	}

	//查询某个组件所有值班人员
	public List<Member> getMemberByAssembly(Integer assemblyID) {

		String hql = "from Member where assemblyID=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, assemblyID);
		List<Member> list = query.list();

		return list;
	}

	//查询所有的值班人员,返回值班人员的id号和值班人员的姓名 
	public Map<Integer, String> getAllMember() {
		Map<Integer, String> map = new HashMap<Integer, String>();

		Query query = sessionFactory.getCurrentSession().createQuery("from Member");
		List<Member> list = query.list();
		for (Member member : list) {
			map.put(member.getId(), member.getMemberName());
		}
		return map;
	}

	//根据值班人员id查询值班人员
	public Member getMember(Integer id) {
		String hql = "from Member where id=?";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<Member> list = query.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//根据值班人员姓名查询值班人员
	public Member getMemberByName(String name) {
		String hql = "from Member where memberName=?";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<Member> list = query.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
