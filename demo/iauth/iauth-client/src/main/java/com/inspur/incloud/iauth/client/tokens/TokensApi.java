package com.inspur.incloud.iauth.client.tokens;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.iauth.client.BaseApi;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;

@Repository("tokensApi")
public interface TokensApi extends BaseApi {

	@RequestMapping(value = "/auth/tokens", method = RequestMethod.GET)
	OperationResult<UserInforModel> checkTokenPower(
			@RequestHeader(value = "X-Auth-Token", required = true) String token,
			@RequestHeader(value = "X-Auth-Keep-Alive", required = false, defaultValue = "true") Boolean keepAlive,
			HttpServletRequest request);
}
