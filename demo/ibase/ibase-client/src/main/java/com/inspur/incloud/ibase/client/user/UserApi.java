package com.inspur.incloud.ibase.client.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.ibase.client.BaseApi;
import com.inspur.incloud.ibase.client.model.user.UserApiModel;

@Repository("userApi")
public interface UserApi extends BaseApi {

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	OperationResult<UserApiModel> queryUserById(@RequestParam(value = "id", required = true) String id,HttpServletRequest request);
}
