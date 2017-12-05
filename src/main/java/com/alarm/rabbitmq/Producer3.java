/**
 * @(#)Producer3.java 2017年11月10日
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

/**
 * @author 张小莲
 * @date 2017年11月10日
 * @version $Revision$
 */
public class Producer3 {

	private static final String EXCHANGE_NAME = "direct_logs";

	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "direct");

		String severity = getSeverity(argv);
		String message = getMessage(argv);

		channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
		System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

		channel.close();
		connection.close();
	}

	private static String getSeverity(String[] strings) {
		if (strings.length < 1)
			return "info";
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
}