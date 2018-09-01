package com.inspur.incloud.ibase.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.inspur.incloud.ibase.dao.UserDao;
import com.inspur.incloud.ibase.model.UserModel;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserModel> implements UserDao {

	public Serializable addUser(UserModel user) {
		save(user);
		return 0;
	}

}
