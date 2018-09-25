package com.inspur.incloud.ibase.client.operatelog;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inspur.incloud.common.util.feign.FeignConfig;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;

@Repository("operateLogApi")
@FeignClient(name = "ibase-service", url = "${ibase-client.url}" ,configuration = FeignConfig.class)
@RequestMapping(value = "/v1")
public interface OperateLogApi{
	
	@RequestMapping(value = "/operatelog/action/add", method = RequestMethod.POST)
	String addOperateLog(@RequestBody LogInfo logInfo,  HttpServletRequest request);
}
