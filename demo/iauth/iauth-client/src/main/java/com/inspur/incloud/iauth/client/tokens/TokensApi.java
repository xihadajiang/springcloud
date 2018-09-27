package com.inspur.incloud.iauth.client.tokens;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
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
@Repository("tokensApi")
@RequestMapping(value = "/v1")
@Api(tags = "认证接口")
public interface TokensApi {

	@ApiOperation(value = "校验用户Token", notes = "校验用户Token")
	@RequestMapping(value = "/auth/tokens", method = RequestMethod.GET)
	@ApiResponses({@ApiResponse(code = 10200, message = "token 无权限.")})
	@ApiImplicitParams({
			@ApiImplicitParam(name = "X-Auth-Token", paramType = "header", required = true, dataType = "String", value = "用户的token"),
			@ApiImplicitParam(name = "X-Auth-Keep-Alive", paramType = "header", required = false, defaultValue = "true", dataType = "Boolean", value = "是否更新token最近更新时间") })
	OperationResult<UserInforModel> checkTokenPower(String token, Boolean keepAlive);
}
