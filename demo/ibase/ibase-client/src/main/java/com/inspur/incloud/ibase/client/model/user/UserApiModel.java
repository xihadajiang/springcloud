package com.inspur.incloud.ibase.client.model.user;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="用户信息")
public class UserApiModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="用户id")
	private String id;
	
	@ApiModelProperty(value="用户名")
	private String name;
	
	@ApiModelProperty(value="Email")
	private String email;
	
	@ApiModelProperty(value="账号")
	private String account;
	
	@ApiModelProperty(value="账号类型")
	private int is_default;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public int getIs_default() {
		return is_default;
	}

	public void setIs_default(int is_default) {
		this.is_default = is_default;
	}

	
	

}
