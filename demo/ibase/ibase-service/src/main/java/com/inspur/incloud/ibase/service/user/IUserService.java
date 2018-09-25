package com.inspur.incloud.ibase.service.user;

import java.util.Map;

import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.ibase.client.model.user.User4Create;
import com.inspur.incloud.ibase.dao.user.model.UserModel;

public interface IUserService {

	void addUser(UserModel user) throws CloudBusinessException;

	PageListBean<UserModel> listUsers(Map<String, Object> condition,
			PageBean page) throws CloudBusinessException;

	UserModel queryUserById(String id) throws CloudBusinessException ;

	void delete(String userId) throws CloudBusinessException;
	
	void updateUser(String userId, User4Create user4Create) throws CloudBusinessException;

}
