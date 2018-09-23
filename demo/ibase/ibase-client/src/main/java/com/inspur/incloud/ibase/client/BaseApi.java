package com.inspur.incloud.ibase.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspur.incloud.ibase.client.config.FeignConfig;
@FeignClient(name = "ibase-service", url = "${ibase-client.url}" ,configuration = FeignConfig.class)
@RequestMapping("/v1")
public interface BaseApi {
}
