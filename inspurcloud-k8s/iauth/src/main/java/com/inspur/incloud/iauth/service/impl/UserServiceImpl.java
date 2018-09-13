package com.inspur.incloud.iauth.service.impl;


import org.springframework.stereotype.Service;

import com.inspur.incloud.iauth.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {

	public boolean checkUser(String tokenId) {
		if (tokenId != null && tokenId.length() > 0) {
			return true;
		} else {
			return false;
		}
		
	}


}
