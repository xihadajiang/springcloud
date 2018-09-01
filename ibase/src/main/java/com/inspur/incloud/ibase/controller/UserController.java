package com.inspur.incloud.ibase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.ibase.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;
	
    @GetMapping(value = "/add")
	public String addUser(@RequestParam String name){
		UserModel user = new UserModel();
		user.setId("1");
		user.setAccount("lxg");
		user.setEmail("a@b.com");
		user.setAccount("lxg");
		user.setIs_default(0);
		iUserService.addUser(user);
		return "success";
	}
}
