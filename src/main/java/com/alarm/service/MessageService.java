package com.alarm.service;

import java.util.List;
import java.util.Map;

import com.alarm.entity.Message;

public interface MessageService {

	//告警信息查询
	public List<Message> getMessage(Integer assembly_id,String start_time,String end_time);

	//增加告警信息
	public void addMessage(Message message);

	//处理告警信息
	public void dealMessage(Message message);
	
	//统计告警量
	public Integer countMessage(Integer assembly_id);
	
	//根据告警号找告警信息
	public Message findMessageById(Integer message_id);
	
	//根据时间告警信息查询
	public List<Message> getMessageByTime(String start_time,String end_time);
}
