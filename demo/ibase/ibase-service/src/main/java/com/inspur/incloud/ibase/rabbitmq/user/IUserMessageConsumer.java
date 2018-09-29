package com.inspur.incloud.ibase.rabbitmq.user;

import org.springframework.messaging.Message;

public interface IUserMessageConsumer {
	
	public void input(Message<Object> message);

}
