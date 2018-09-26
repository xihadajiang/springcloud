package com.inspur.incloud.ibase.rabbitmq.provider;

import com.inspur.incloud.ibase.client.model.user.UserApiModel;

public interface IMessageProvider {
	
	 public void send(UserApiModel company) ;

}
