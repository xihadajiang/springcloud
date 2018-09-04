package com.inspur.incloud.ibase.api.model;

import java.io.Serializable;

public class UserApiModel implements Serializable{
	
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

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String email;
	
	private String account;
	
	private int is_default;
	
	

}
