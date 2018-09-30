package com.inspur.incloud.ibase.client.operatelog;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Service("operateLogApi")
@FeignClient(name = "ibase-service", url = "${ibase-client.url}" )
@RequestMapping(value = "/v1/operatelog")
@Api(tags = "操作日志接口")
public interface OperateLogApi{
	
	@ApiOperation(value = "添加操作日志", notes = "记录用户操作日志信息")
	@ApiResponses({
		@ApiResponse(code = 10001, message = "这里写错误信息."),
	})
	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
	String addOperateLog(@ApiParam @RequestBody LogInfo logInfo);
}
