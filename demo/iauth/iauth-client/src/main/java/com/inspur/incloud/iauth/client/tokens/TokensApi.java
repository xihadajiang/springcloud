package com.inspur.incloud.iauth.client.tokens;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@FeignClient(name = "iauth-service", url = "${iauth-client.url}" )
@Repository("tokensApi")
@RequestMapping(value = "/v1")
@Api(value = "/panelsssa", description = "Operations for Swipe Panel Locations")
@RestController
public interface TokensApi {
	
	@ApiOperation(value = "Get list of all panels IDs")
	@RequestMapping(value = "/auth/tokens", method = RequestMethod.GET)
	@ResponseBody
	OperationResult<UserInforModel> checkTokenPower(
			@RequestHeader(value = "X-Auth-Token", required = true) String token,
			@RequestHeader(value = "X-Auth-Keep-Alive", required = false, defaultValue = "true") Boolean keepAlive);
}
