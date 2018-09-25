package com.inspur.incloud.ibase.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.common.exception.CloudDBException;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;
import com.inspur.incloud.iauth.client.tokens.TokensApi;
import com.inspur.incloud.ibase.client.model.user.User4Create;
import com.inspur.incloud.ibase.dao.user.UserDao;
import com.inspur.incloud.ibase.dao.user.model.UserModel;
import com.inspur.incloud.ibase.service.user.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TokensApi tokensApi;
	
	@Transactional(rollbackFor=Exception.class)
	public void addUser(UserModel user) throws CloudBusinessException {
		try {
			userDao.addUser(user);
			Long.parseLong(user.getName());
		} catch (CloudDBException e) {
			logger.error("----------------------------",e);
			List<String> args = new ArrayList<String>();
			args.add("test");
			throw new CloudBusinessException("00000002", args);
		}
		
		
	}

	public UserModel queryUserById(String id) throws CloudBusinessException  {
		try {
			OperationResult<UserInforModel> userAuth = tokensApi.checkTokenPower("sss", false);
			UserInforModel auth = userAuth.getResData();
			logger.error(auth.getAccount());
			return userDao.queryUserById(id);
		} catch(CloudDBException e) {
			List<String> args = new ArrayList<String>();
			args.add("test");
			throw new CloudBusinessException("00000002", args);
		}
		
	}


    public PageListBean<UserModel> listUsers(Map<String, Object> condition,
			PageBean page) throws CloudBusinessException {
		PageListBean<UserModel> result = null;
		logger.error("++++++++++++++++++++++++=");
		try {
			result = userDao.listUsers(condition, page);
			if (null == result || result.getTotal() == 0) {
				List<String> args = new ArrayList<String>();
				args.add("test");
				throw new CloudBusinessException("00000002", args);
			}
		} catch(CloudDBException e) {
			List<String> args = new ArrayList<String>();
			args.add("test");
			throw new CloudBusinessException("00000002", args);
		}
		
		return result;
	}

	public void delete(String userId) throws CloudBusinessException {
		try {
			UserModel user= userDao.queryUserById(userId);
			if (null == user) {
				List<String> args = new ArrayList<String>();
				args.add("test");
				throw new CloudBusinessException("00000003", args);
			}
			userDao.deletUser(user);
		} catch(CloudDBException e) {
			List<String> args = new ArrayList<String>();
			args.add("test");
			throw new CloudBusinessException("00000002", args);
		}
		
		
	}
	
	public void updateUser(String userId, User4Create user4Create)
			throws CloudBusinessException {
		try {
			UserModel user= userDao.queryUserById(userId);
			if (null == user) {
				List<String> args = new ArrayList<String>();
				args.add("test");
				throw new CloudBusinessException("00000003", args);
			}
			user.setAccount(user4Create.getAccount());
			user.setEmail(user4Create.getEmail());
			user.setName(user4Create.getName());
			userDao.updateUser(user);
		} catch(CloudDBException e) {
			List<String> args = new ArrayList<String>();
			args.add("test");
			throw new CloudBusinessException("00000002", args);
		}
		
		
	}

}
