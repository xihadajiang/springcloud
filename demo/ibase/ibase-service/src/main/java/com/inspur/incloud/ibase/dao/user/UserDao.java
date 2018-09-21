package com.inspur.incloud.ibase.dao.user;

import java.io.Serializable;
import java.util.Map;

import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.ibase.dao.user.model.UserModel;

public interface UserDao {
	
	Serializable addUser(UserModel user);

	PageListBean<UserModel> listUsers(Map<String, Object> condition,
			final PageBean page);

	UserModel queryUserById(String id);

	void deletUser(UserModel user);

	void updateUser(UserModel user);

}
