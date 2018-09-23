package com.inspur.incloud.iauth.service.user;


import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.iauth.dao.user.model.UserModel;

public interface IUserService {

	UserModel queryUserById(String id) throws CloudBusinessException;
}
