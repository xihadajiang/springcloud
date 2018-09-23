package com.inspur.incloud.iauth.dao.user.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.inspur.incloud.common.dao.BaseDaoImpl;
import com.inspur.incloud.iauth.dao.user.UserDao;
import com.inspur.incloud.iauth.dao.user.model.UserModel;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserModel> implements UserDao {

	
	public UserModel queryUserById(String id) {
		UserModel user = null;
		List<UserModel> list = null;
		list = (List<UserModel>) getHibernateTemplate().find("from UserModel where id = ? ", id);
		if (null != list && list.size() > 0) {
			user = list.get(0);
		}
		return user;
	}


}
