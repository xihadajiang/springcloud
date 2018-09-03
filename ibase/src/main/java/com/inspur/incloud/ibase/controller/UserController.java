package com.inspur.incloud.ibase.controller;

import java.util.UUID;

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
		String id = UUID.randomUUID().toString();
		user.setId(id);
		user.setAccount("lxg");
		user.setEmail("a@b.com");
		user.setAccount("lxg");
		user.setIs_default(0);
		user.setName("lxg");
		iUserService.addUser(user);
		return "success";
	}
}
