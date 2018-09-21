package com.inspur.incloud.ibase.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspur.incloud.ibase.client.config.FeignConfig;
@FeignClient(name = "ibase-service", configuration = FeignConfig.class)
@RequestMapping("/ibase/v1")
public interface BaseApi {
}
