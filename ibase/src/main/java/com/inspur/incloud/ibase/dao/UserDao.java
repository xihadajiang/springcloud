package com.inspur.incloud.ibase.dao;

import java.io.Serializable;

import com.inspur.incloud.ibase.model.UserModel;

public interface UserDao {
	
	Serializable addUser(UserModel user);

}
