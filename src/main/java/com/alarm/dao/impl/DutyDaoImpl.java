/**
 * @(#)DutyDaoImpl.java 2017年8月8日
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alarm.dao.DutyDao;
import com.alarm.dao.MemberDao;
import com.alarm.entity.Duty;
import com.alarm.entity.Member;

/**
 * 值班表的删，修改，查询
 * 
 * @author 张小莲
 * @date 2017年8月8日
 * @version $Revision$
 */
@Repository
public class DutyDaoImpl implements DutyDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private MemberDao memberDao;

	//值班情况查询
	public List<Duty> getDuty(Integer assemblyID) {
		List<Duty> duties = new ArrayList<Duty>();
		String hql = "from Duty where assemblyID=" + assemblyID;
		duties = sessionFactory.getCurrentSession().createQuery(hql).list();
		return duties;
	}

	//查询某个组件现在这个时刻的值班人员姓名，当前时间以系统为准
	public String getDutyByNow(Integer assemblyID) {
		String hql = "select d.memberID from Duty as d where d.assemblyID=? and d.week=? and d.timeType=?";
		//获取查询当天的星期数,和时间数
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("修改之前的week：" + weekday);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int timeType;
		if (weekday == 1) {
			weekday = 7;
		}
		else {
			weekday -= 1;
		}
		if (hour >= 0 && hour < 8) {
			timeType = 1;
		}
		else if (hour >= 8 && hour < 16) {
			timeType = 2;
		}
		else {
			timeType = 3;
		}
		System.out.println("week==" + weekday + "  id==" + assemblyID + "  tpye==" + timeType);
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, assemblyID);
		query.setInteger(1, weekday);
		query.setInteger(2, timeType);
		List<Integer> list = query.list();
		if (list.size() > 0) {
			Integer memberID = list.get(0);
			Member member = memberDao.getMember(memberID);
			if (member != null) {
				return member.getMemberName();
			}
		}
		return "";
	}

	//查询某个组件当天的值班人员姓名，当前时间以系统为准
	public Map<Integer, String> getDutyByToday(Integer assemblyID) {
		String hql = "from Duty as d where d.assemblyID=? and d.week=?";
		//获取查询当天的星期数,和时间数
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		if (weekday == 1) {
			weekday = 7;
		}
		else {
			weekday -= 1;
		}
		System.out.println("week==" + weekday + "  id==" + assemblyID);
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, assemblyID);
		query.setInteger(1, weekday);
		List<Duty> list = query.list();
		//System.out.println("the result's MemberID=" + list);
		Map<Integer, String> result = new HashMap<Integer, String>();
		if (list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				Integer memberID = list.get(i).getMemberID();
				//System.out.println("the result's MemberID=" + memberID);
				Member member = memberDao.getMember(memberID);
				System.out.println("the result's MemberID=" + member);
				if (member != null) {
					result.put(list.get(i).getTimeType(), member.getMemberName());
					System.out.println("类型=" + list.get(i).getTimeType() + " 值班人员姓名="
							+ member.getMemberName());
				}
			}
		}
		return result;
	}

	//保存或修改具体某时刻的值班人员
	public void saveOrUpdateDuty(Integer assemblyID, Integer newMemberID, Integer timeType) {
		Duty duty = new Duty();
		org.hibernate.Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		//先判断原先这个时刻是否有这条记录
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		if (weekday == 1) {
			weekday = 7;
		}
		else {
			weekday -= 1;
		}
		String hql = "from Duty as d where d.week=? and d.timeType=? and d.assemblyID=?";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, weekday);
		query.setInteger(1, timeType);
		query.setInteger(2, assemblyID);
		//如果有这个

		if (query.list().size() > 0) {
			duty = (Duty) query.list().get(0);
			duty.setMemberID(newMemberID);
		}
		else {
			duty.setAssemblyID(assemblyID);
			duty.setId(null);
			duty.setMemberID(newMemberID);
			duty.setTimeType(timeType);
			duty.setWeek(weekday);
		}
		session.saveOrUpdate(duty);
		tx.commit();

	}

	//保存或修改具体某个时刻的值班表中一个人
	public void saveOrUpdateDutyOnTable(Integer assemblyID, Integer newMemberID, Integer timeType,
			Integer weekday) {
		Duty duty = new Duty();
		org.hibernate.Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		//先判断原先这个时刻是否有这条记录
		String hql = "from Duty as d where d.week=? and d.timeType=? and d.assemblyID=?";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, weekday);
		query.setInteger(1, timeType);
		query.setInteger(2, assemblyID);
		//如果有这个

		if (query.list().size() > 0) {
			duty = (Duty) query.list().get(0);
			duty.setMemberID(newMemberID);
		}
		else {
			duty.setAssemblyID(assemblyID);
			duty.setId(null);
			duty.setMemberID(newMemberID);
			duty.setTimeType(timeType);
			duty.setWeek(weekday);
		}
		session.saveOrUpdate(duty);
		tx.commit();

	}

}
