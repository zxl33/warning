package com.alarm.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alarm.dao.MessageDao;
import com.alarm.entity.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Message> getMessage(Integer assambly_id, String start_time, String end_time) {
		// TODO Auto-generated method stub
		String hql = "from Message where assembly_id = ? and last_time > ? and last_time < ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, assambly_id);
		query.setString(1, start_time);
		query.setString(2, end_time);
		List<Message> list = query.list();
		return list;
	}

	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		System.out.println(message.getAction_describe());
		System.out.println(message.getRoom());
		sessionFactory.getCurrentSession().save(message);
	}

	public void dealMessage(Message message) {
		// TODO Auto-generated method stub
		System.out.println(message.getMessage_id());
		System.out.println(message.getAction_describe());
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery("update Message set action=? , action_reason=? , action_describe=? where message_id=?");
		query.setBoolean(0, message.getAction());
		query.setString(1, message.getAction_reason());
		query.setString(2, message.getAction_describe());
		query.setInteger(3, message.getMessage_id());
		query.executeUpdate();	
	}

	public Integer countMessage(Integer assembly_id) {
		// TODO Auto-generated method stub
//		String hql = "select assembly_id,count(*) from message group by assembly_id";
//		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		Map<String, Integer> list = query.list();
//		return list;
		String hql = "select count(*) from Message where assembly_id=? group by assembly_id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, assembly_id);
		List list = query.list();
		if(list.size() > 0)
		{
			Number num = (Number)query.list().get(0);
			return num.intValue();
		}
		return 0;
	}

	public Message findMessageById(Integer message_id) {
		String hql = "from Message where message_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, message_id);
		Message message = (Message)query.list().get(0);
		return message;
	}
	
	public List<Message> getMessageByTime(String start_time,String end_time)
	{
		String hql = "from Message where last_time > ? and last_time < ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, start_time);
		query.setString(1, end_time);
		List<Message> list = query.list();
		return list;
	}
}
