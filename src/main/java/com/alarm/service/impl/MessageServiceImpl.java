package com.alarm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alarm.dao.MessageDao;
import com.alarm.entity.Message;
import com.alarm.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	public List<Message> getMessage(Integer assembly_id, String start_time, String end_time) {
		// TODO Auto-generated method stub
		if (assembly_id == null) {
			assembly_id = -1;
		}
		if (start_time == null) {
			start_time = "1970-01-01";
		}
		if (end_time == null) {
			//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//			end_time = df.format(new Date());
			end_time = "2027-12-31";
		}
		List<Message> list = messageDao.getMessage(assembly_id, start_time, end_time);
		return list;
	}

	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		messageDao.addMessage(message);
		return;
	}

	public void dealMessage(Message message) {
		// TODO Auto-generated method stub
		messageDao.dealMessage(message);
		return;
	}

	public Integer countMessage(Integer assembly_id) {
		// TODO Auto-generated method stub
		Integer count = messageDao.countMessage(assembly_id);
		System.out.println(count);
		return count;
	}

	public Message findMessageById(Integer message_id) {
		Message message = messageDao.findMessageById(message_id);
		return message;
	}

	//根据时间告警信息查询
	public List<Message> getMessageByTime(String start_time, String end_time) {
		if (start_time == null) {
			start_time = "1970-01-01";
		}
		if (end_time == null) {
			//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//			end_time = df.format(new Date());
			end_time = "2027-12-31";
		}
		return messageDao.getMessageByTime(start_time, end_time);
	}
}
