package com.inspur.incloud.ibase.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import com.inspur.incloud.ibase.client.config.FeignConfig;
@FeignClient(name = "ibase-service", configuration = FeignConfig.class)
public interface BaseApi {
}
