package com.inspur.incloud.iauth.client.tokens;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@FeignClient(name = "iauth-service", url = "${iauth-client.url}")
@Service("tokensApi")
@RequestMapping(value = "/v1")
@Api(tags = "认证接口")
public interface TokensApi {

	@ApiOperation(value = "校验用户Token", notes = "校验用户Token")
	@RequestMapping(value = "/auth/tokens", method = RequestMethod.GET)
	@ApiResponses({@ApiResponse(code = 20010, message = "token 无权限.")})
	@ApiImplicitParams({
			@ApiImplicitParam(name = "X-Auth-Token", paramType = "header", required = true, dataType = "String", value = "用户的Token"),
			@ApiImplicitParam(name = "X-Auth-Keep-Alive", paramType = "header", required = false, defaultValue = "true", dataType = "Boolean", value = "是否更新token最近更新时间") })
	OperationResult<UserInforModel> checkTokenPower(
			@RequestHeader(name = "X-Auth-Token", required = true) String token,
			@RequestHeader(name = "X-Auth-Keep-Alive", required = false, defaultValue = "true") Boolean keepAlive);
}
