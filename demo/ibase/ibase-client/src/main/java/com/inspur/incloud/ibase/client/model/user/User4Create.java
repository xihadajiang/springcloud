package com.inspur.incloud.ibase.client.model.user;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="用户信息")
public class User4Create implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="用户名")
	private String name;
	
	@ApiModelProperty(value="Email")
	private String email;
	
	@ApiModelProperty(value="账号")
	private String account;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	
	

}
