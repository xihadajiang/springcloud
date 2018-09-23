package com.inspur.incloud.iauth.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "iauth-service", url = "${iauth-client.url}" )
@RequestMapping("/v1")
public interface BaseApi {
}
