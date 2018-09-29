package com.inspur.incloud.ibase.rabbitmq.user;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface IUserMessageProcessor {
	
	
	public String INPUT_USER = "inputUser";
	public String OUTPUT_USER = "outputUser";

	@Input(INPUT_USER)
	SubscribableChannel inputUser();

	@Output(OUTPUT_USER)
	MessageChannel outputUser();//方法名称可随意定义，不一定域OUTPUT_USER一致
	
}
