package com.alarm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alarm.dao.ManagerDao;
import com.alarm.entity.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//管理员列表
	public List<Manager> getAllManager() {
		// TODO Auto-generated method stub
		List<Manager> list = sessionFactory.getCurrentSession().createQuery("from Manager").list();
		return list;
	}

	//根据管理员名字查询管理员
	public Manager getManagerByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Manager where name=?";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<Manager> list = query.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//增加管理员
	public void addManager(Manager manager) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(manager);
	}

	//删除管理员
	public void deleteManager(Manager manager) {
		// TODO Auto-generated method stub
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery("delete from Manager where manager_id=?");
		query.setInteger(0, manager.getManager_id());
		query.executeUpdate();	
	}

	//管理员验证登录，根据邮箱和密码
	public Manager checkManager(Manager manager) {
		// TODO Auto-generated method stub
		String hql = "from Manager where email=? and password=?";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, manager.getEmail());
		query.setString(1, manager.getPassword());
		List<Manager> list = query.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
