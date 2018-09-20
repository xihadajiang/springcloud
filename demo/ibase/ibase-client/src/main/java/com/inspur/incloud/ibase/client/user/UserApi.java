package com.inspur.incloud.ibase.client.user;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inspur.incloud.ibase.client.BaseApi;
import com.inspur.incloud.ibase.client.model.user.UserApiModel;

@Repository("iBaseApi")
public interface UserApi extends BaseApi{
	    /**
	     * 调取用户名称
	     *
	     * @return 用户名称
	     */
	    @GetMapping("/user/info")
	    UserApiModel queryUserById(@RequestParam(value = "id", required = true) String id);
}
