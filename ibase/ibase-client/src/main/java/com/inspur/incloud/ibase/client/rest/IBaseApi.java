package com.inspur.incloud.ibase.client.rest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inspur.incloud.ibase.client.hystrix.IBaseHystrix;
import com.inspur.incloud.ibase.client.model.UserApiModel;

@FeignClient(name = "ibase-service", fallback = IBaseHystrix.class)
@Repository("iBaseApi")
public interface IBaseApi {
	    /**
	     * 调取用户名称
	     *
	     * @return 用户名称
	     */
	    @GetMapping("/user/info")
	    UserApiModel queryUserById(@RequestParam(value = "id", required = true) String id);
}
