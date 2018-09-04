package com.inspur.incloud.icompute.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ibase")
public interface IBaseService {
	    /**
	     * 调取博客名称
	     *
	     * @return 博客名称
	     */
	    @GetMapping("/user/info")
	    String queryUserById(@RequestParam(value = "id", required = true) String id);
}
