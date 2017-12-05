/**
 * @(#)Producer4.java 2017年11月10日
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

package com.alarm.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @author 张小莲
 * @date 2017年11月10日
 * @version $Revision$
 */
public class Producer4 {

	//	private static final String EXCHANGE_NAME = "topic_logs";

	public void produceMessage(String exchangeName, String queueName, String routingKey,
			String message) {
		Connection connection = null;
		Channel channel = null;
		try {
			//创建连接工厂及配置
			ConnectionFactory connectionFactory = new ConnectionFactory();
			connectionFactory.setHost("localhost");

			//创建连接和通道
			connection = connectionFactory.newConnection();
			channel = connection.createChannel();

			//创建exchange，queue
			channel.exchangeDeclare(exchangeName, "topic", true);
			channel.queueDeclare(queueName, true, false, false, null);

			//发送消息
			channel.basicPublish(exchangeName, routingKey, MessageProperties.PERSISTENT_TEXT_PLAIN,
					message.getBytes("UTF-8"));
			System.out.println("[x] Sent '" + routingKey + "':'" + message + "'");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				}
				catch (Exception ignore) {
				}
			}
		}

	}

	/*	public static void main(String[] argv) {
			Connection connection = null;
			Channel channel = null;
			try {
				ConnectionFactory factory = new ConnectionFactory();
				factory.setHost("localhost");
	
				connection = factory.newConnection();
				channel = connection.createChannel();
	
				channel.exchangeDeclare(EXCHANGE_NAME, "topic");
	
				String routingKey = getRouting(argv);
				String message = getMessage(argv);
	
				channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
				System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
	
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (connection != null) {
					try {
						connection.close();
					}
					catch (Exception ignore) {
					}
				}
			}
		}
	
		private static String getRouting(String[] strings) {
			if (strings.length < 1)
				return "anonymous.info";
			return strings[0];
		}
	
		private static String getMessage(String[] strings) {
			if (strings.length < 2)
				return "Hello World!";
			return joinStrings(strings, " ", 1);
		}
	
		private static String joinStrings(String[] strings, String delimiter, int startIndex) {
			int length = strings.length;
			if (length == 0)
				return "";
			if (length < startIndex)
				return "";
			StringBuilder words = new StringBuilder(strings[startIndex]);
			for (int i = startIndex + 1; i < length; i++) {
				words.append(delimiter).append(strings[i]);
			}
			return words.toString();
		}
		*/
}
