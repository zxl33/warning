package com.alarm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alarm.dao.TempDao;
import com.alarm.entity.Temp;

@Repository
public class TempDaoImpl implements TempDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Temp> getAllTemp() {
		// TODO Auto-generated method stub
		List<Temp> list = sessionFactory.getCurrentSession().createQuery("from Temp").list();
		return list;
	}

	public Temp getTempByName(String name) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Temp where name=?");
		query.setString(0, name);
		if (query.list().size() != 0) {
			Temp temp = (Temp) query.list().get(0);
			return temp;
		}
		return null;
	}

	public void addTemp(Temp temp) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(temp);
	}

	public void deleteTemp(Temp temp) {
		// TODO Auto-generated method stub
		org.hibernate.Query query = sessionFactory.getCurrentSession()
				.createQuery("delete from Temp where temp_id=?");
		query.setInteger(0, temp.getTemp_id());
		query.executeUpdate();

	}

	public List<String> findTempByType(Boolean type) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Temp where type=?");
		query.setBoolean(0, type);
		List<String> name_list = new ArrayList();
		List<Temp> list = query.list();
		Integer list_num = list.size();
		if (list_num != 0) {
			for (int i = 0; i < list_num; i++) {
				name_list.add(list.get(i).getName());
			}
		}
		return name_list;
	}

	public Temp getTempByID(Integer id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Temp where temp_id=?");
		query.setInteger(0, id);
		if (query.list().size() != 0) {
			Temp temp = (Temp) query.list().get(0);
			return temp;
		}
		return null;
	}

}
