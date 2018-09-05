package com.inspur.incloud.ibase.api.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.inspur.incloud.ibase.api.model.UserApiModel;
import com.inspur.incloud.ibase.api.service.IBaseApi;

@Component
public class IBaseHystrix implements IBaseApi {

	public UserApiModel queryUserById(@RequestParam(value = "id", required = true) String id) {
		UserApiModel model = new UserApiModel();
		model.setName("I am tired, i need a wake");
		return model;
	}

}
