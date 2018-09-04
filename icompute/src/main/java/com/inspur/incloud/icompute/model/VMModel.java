package com.inspur.incloud.icompute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "t_rs_vm_info")
public class VMModel implements Serializable{
	
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id",updatable = false, nullable = false)
	private String id;
	
    @Column(name = "name",updatable = false, nullable = false)
	private String name;
	
    @Column(name = "user_id",updatable = false, nullable = false)
	private String userId;
	
	

}
