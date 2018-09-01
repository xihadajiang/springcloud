package com.inspur.incloud.ibase.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspur.incloud.ibase.dao.UserDao;
import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.ibase.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void addUser(UserModel user) {
		userDao.addUser(user);
		
	}

}
