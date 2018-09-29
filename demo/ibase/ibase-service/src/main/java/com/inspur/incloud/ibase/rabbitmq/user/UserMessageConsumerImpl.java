package com.inspur.incloud.ibase.rabbitmq.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding(IUserMessageProcessor.class)
public class UserMessageConsumerImpl implements IUserMessageConsumer{
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@StreamListener(IUserMessageProcessor.INPUT_USER)
	@Override
	public void input(Message<Object> message) {
		
		logger.error("********************" + message.getPayload());
		System.out.println("********************" + message.getPayload());
		
	}
	

}
