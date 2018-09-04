package com.inspur.incloud.swagger.controller.user.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User4Create")
public class User4Create implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "用户名称", example = "wangqiang")
	private String name;
	
	@ApiModelProperty(value = "用户邮箱", example = "wangqiangbj@inspur.com")
	private String email;
	
	@ApiModelProperty(value = "用户电话", example = "12345678")
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

