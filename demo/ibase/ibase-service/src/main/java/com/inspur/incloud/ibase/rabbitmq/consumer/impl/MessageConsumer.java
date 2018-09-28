package com.inspur.incloud.ibase.rabbitmq.consumer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inspur.incloud.ibase.client.model.user.UserApiModel;
import com.inspur.incloud.ibase.rabbitmq.consumer.IMessageConsumer;

@Component
//@EnableBinding(Sink.class)
public class MessageConsumer implements IMessageConsumer {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
//	@StreamListener(Sink.INPUT)
//	public void input(Message<UserApiModel> message) {
//		logger.error("********************" + message.getPayload().getAccount());
//
//	}

}
