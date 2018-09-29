package com.inspur.incloud.ibase.rabbitmq.user;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@EnableBinding(IUserMessageProcessor.class)
public class UserMessageProviderImpl implements IUserMessageProvider{
	
	
	@Resource
	private MessageChannel outputUser;//变量名称应该跟 IUserMessageProcessor中 OUTPUT_USER 一致
		
	@Override
	public void send(Object o) {
		// TODO Auto-generated method stub
		this.outputUser.send(MessageBuilder.withPayload(o).build());
		
	}

}
