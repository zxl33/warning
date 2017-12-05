/**
 * @(#)RabbitMQController.java 2017年11月13日
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

package com.alarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.entity.Record;
import com.alarm.rabbitmq.Producer4;
import com.alarm.rabbitmq.Receiver4;
import com.alarm.service.impl.RabbitServiceImpl;

/**
 * @author 张小莲
 * @date 2017年11月13日
 * @version $Revision$
 */

@Controller
public class RabbitMQController {
	@Autowired
	private RabbitServiceImpl rabbitService;

	@RequestMapping("/rabbit/video")
	public String playVideo() {
		return "/rabbitMQ";
	}

	@RequestMapping("/rabbit/storeDanmu")
	@ResponseBody
	public void storeDanmu(String danmu) {
		Producer4 producer = new Producer4();
		System.out.println(danmu);
		rabbitService.addRecord(danmu, "queue_test");
		producer.produceMessage("exchange_test", "queue_test", "danmu", danmu);
		return;
	}

	@RequestMapping("/rabbit/getDanmu")
	public @ResponseBody String getDanmu() {
		Receiver4 receiver = new Receiver4();
		receiver.consumerMessage("exchange_test", "queue_test", "danmu");
		java.util.List<Record> result = rabbitService.getRecords("queue_test");
		StringBuffer danmuss = new StringBuffer();
		danmuss.append("[");
		for (int i = 0; i < result.size(); i++) {

			danmuss.append("\'").append(result.get(i).getMessage()).append("\',");
		}
		danmuss.append("]");
		System.out.println(danmuss.toString());
		//return "['{ \"text\":\"dasfsadf\",\"color\":\"#b340b3\",\"size\":\"1\",\"position\":\"0\",\"time\":230}']";
		return danmuss.toString();
	}
}
