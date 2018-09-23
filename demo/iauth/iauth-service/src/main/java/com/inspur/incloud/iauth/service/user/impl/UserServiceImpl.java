package com.inspur.incloud.iauth.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.iauth.dao.user.UserDao;
import com.inspur.incloud.iauth.dao.user.model.UserModel;
import com.inspur.incloud.iauth.service.user.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;

	public UserModel queryUserById(String id) throws CloudBusinessException {
        try {
			return userDao.queryUserById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			List<String> args = new ArrayList<String>();
			args.add("test");
			throw new CloudBusinessException("00000002", args);
		}
		
	}
}
