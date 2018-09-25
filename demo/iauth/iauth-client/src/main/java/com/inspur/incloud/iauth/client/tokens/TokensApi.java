package com.inspur.incloud.iauth.client.tokens;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;

@FeignClient(name = "iauth-service", url = "${iauth-client.url}" )
@Repository("tokensApi")
@RequestMapping(value = "/v1")
public interface TokensApi {

	@RequestMapping(value = "/auth/tokens", method = RequestMethod.GET)
	OperationResult<UserInforModel> checkTokenPower(
			@RequestHeader(value = "X-Auth-Token", required = true) String token,
			@RequestHeader(value = "X-Auth-Keep-Alive", required = false, defaultValue = "true") Boolean keepAlive);
}
