package com.inspur.incloud.ibase.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.ibase.service.IUserService;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@ApiOperation(value="添加用户信息", notes="添加用户信息")
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
    
    @GetMapping(value = "/list")
    PageListBean<UserModel> listUsers(@RequestParam String name) {
    	PageBean page = new PageBean();
    	page.setCurrentPage(1);
    	page.setPageSize(10);
    	Map<String, Object> condition = new HashMap<String, Object>();
    	condition.put("name", name);
    	
    	PageListBean<UserModel> pageLsit = iUserService.listUsers(condition, page);
    	
		return pageLsit;
    	
    }
}
