package com.inspur.incloud.ibase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.ibase.api.model.UserApiModel;
import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.ibase.service.IUserService;

@RestController
public class UserApi {

	@Autowired
	private IUserService iUserService;
	
	@GetMapping(value = "/user/info")
	UserApiModel queryUserById(@RequestParam String id) {
    	UserModel user = new UserModel();
    	UserApiModel apiModel = new UserApiModel();
    	user = iUserService.queryUserById(id);
    	if (null != user) {
    		apiModel.setAccount(user.getAccount());
    		apiModel.setName(user.getName());
    		apiModel.setEmail(user.getEmail());
    		apiModel.setId(user.getId());
    		apiModel.setIs_default(user.getIs_default());
    	}
		return apiModel;
    	
    }
}
