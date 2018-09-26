package com.inspur.incloud.ibase.rabbitmq.provider.impl;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.inspur.incloud.ibase.client.model.user.UserApiModel;
import com.inspur.incloud.ibase.rabbitmq.provider.IMessageProvider;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
	
	@Resource
	private MessageChannel output;

	public void send(UserApiModel userInfo) {
		
		output.send(MessageBuilder.withPayload(userInfo).build());
		
	} 

}
