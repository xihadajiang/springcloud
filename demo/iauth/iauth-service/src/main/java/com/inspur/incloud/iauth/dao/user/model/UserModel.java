package com.inspur.incloud.iauth.dao.user.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "t_ba_user22222")
public class UserModel implements Serializable{
	
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

	@Id
    @Column(name = "id",updatable = false, nullable = false)
	private String id;
	
    @Column(name = "name",updatable = false, nullable = false)
	private String name;
	
    @Column(name = "email",updatable = false, nullable = false)
	private String email;
	
    @Column(name = "account",updatable = false, nullable = false)
	private String account;
	
    @Column(name = "is_default",updatable = false, nullable = false)
	private int is_default;
	
	

}
