package com.inspur.incloud.ibase.dao;

import java.io.Serializable;
import java.util.Map;

import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

public interface UserDao {
	
	Serializable addUser(UserModel user);

	PageListBean<UserModel> listUsers(Map<String, Object> condition,
			final PageBean page);

}
