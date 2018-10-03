package com.inspur.incloud.ibase.dao.user;

import java.io.Serializable;
import java.util.Map;

import com.inspur.incloud.common.dao.BaseDao;
import com.inspur.incloud.common.exception.CloudDBException;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.ibase.dao.user.model.UserModel;

public interface UserDao extends BaseDao<UserModel, String> {
	
	PageListBean<UserModel> listUsers(Map<String, Object> condition,
			final PageBean page) throws CloudDBException ;

	UserModel queryUserById(String id) throws CloudDBException ;

}
