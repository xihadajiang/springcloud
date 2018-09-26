package com.inspur.incloud.ibase.rabbitmq.consumer;

import org.springframework.messaging.Message;

import com.inspur.incloud.ibase.client.model.user.UserApiModel;

public interface IMessageConsumer {
	
	public void input(Message<UserApiModel> message);

}
