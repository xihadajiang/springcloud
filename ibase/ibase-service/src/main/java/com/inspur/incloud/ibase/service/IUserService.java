package com.inspur.incloud.ibase.service;

import java.util.Map;

import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

public interface IUserService {

	void addUser(UserModel user);

	PageListBean<UserModel> listUsers(Map<String, Object> condition,
			PageBean page);

	UserModel queryUserById(String id);

}
