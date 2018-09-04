package com.inspur.incloud.iauth.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.iauth.service.IUserService;


@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;
	
    @GetMapping(value = "/token/check")
	public String checkUserToken(@RequestHeader(name = "auth-token") String tokenId){
		iUserService.checkUser(tokenId);
		return "success";
	}
    
	
	@GetMapping(value = "/users/token")
	public Map getUserToken(@RequestParam(name = "tokenId", required = true ) String tokenId){
		Map u = new HashMap();
		u.put("user", "userName");
		u.put("tokenId",tokenId);
		return u;
	}
    
}
