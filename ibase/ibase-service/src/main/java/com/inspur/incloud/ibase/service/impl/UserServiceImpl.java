package com.inspur.incloud.ibase.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspur.incloud.ibase.dao.UserDao;
import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.ibase.service.IUserService;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void addUser(UserModel user) {
		userDao.addUser(user);
		
	}

	@Transactional
	public PageListBean<UserModel> listUsers(Map<String, Object> condition,
			PageBean page) {
		// TODO Auto-generated method stub
		return userDao.listUsers(condition, page);
	}

	public UserModel queryUserById(String id) {
		return userDao.queryUserById(id);
	}

}
