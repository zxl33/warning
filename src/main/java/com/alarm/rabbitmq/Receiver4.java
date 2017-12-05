/**
 * @(#)Receiver4.java 2017年11月10日
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

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * @author 张小莲
 * @date 2017年11月10日
 * @version $Revision$
 */
public class Receiver4 {

	//private static final String EXCHANGE_NAME = "topic_logs";

	public StringBuffer consumerMessage(String exchangeName, String queueName, String routingKey) {
		Connection connection = null;
		Channel channel = null;
		final StringBuffer danmuss = new StringBuffer();
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

			//绑定路由规则
			channel.queueBind(queueName, exchangeName, routingKey);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

			//消费消息
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope,
						AMQP.BasicProperties properties, byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					System.out.println(
							" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
					danmuss.append(message);
				}
			};
			channel.basicConsume(queueName, true, consumer);

		}
		catch (Exception e) {
			e.printStackTrace();

		}
		return danmuss;
	}

	/*public static void main(String[] argv) throws Exception {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
	
			channel.exchangeDeclare(EXCHANGE_NAME, "topic");
			String queueName = channel.queueDeclare().getQueue();
	
			if (argv.length < 1) {
				System.err.println("Usage: ReceiveLogsTopic [binding_key]...");
				System.exit(1);
			}
	
			for (String bindingKey : argv) {
				channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
			}
	
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope,
						AMQP.BasicProperties properties, byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					System.out.println(
							" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
				}
			};
			channel.basicConsume(queueName, true, consumer);
		}*/
}
