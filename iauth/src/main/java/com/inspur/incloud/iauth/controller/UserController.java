package com.inspur.incloud.iauth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.iauth.service.IUserService;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@ApiOperation(value="检查用户token", notes="检查用户token")
    @GetMapping(value = "/token/check")
	public String checkUserToken(@RequestHeader(name = "auth-token") String tokenId){
		iUserService.checkUser(tokenId);
		return "success";
	}
    
}
