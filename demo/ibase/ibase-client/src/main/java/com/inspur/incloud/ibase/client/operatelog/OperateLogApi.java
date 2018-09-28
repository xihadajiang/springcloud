package com.inspur.incloud.ibase.client.operatelog;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;

@Repository("operateLogApi")
@FeignClient(name = "ibase-service", url = "${ibase-client.url}" )
@RequestMapping(value = "/v1/operatelog")
@RestController
public interface OperateLogApi{
	
	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
	String addOperateLog(@RequestBody LogInfo logInfo);
}
