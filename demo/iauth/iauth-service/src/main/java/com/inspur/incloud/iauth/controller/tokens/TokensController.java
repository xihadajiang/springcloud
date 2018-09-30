package com.inspur.incloud.iauth.controller.tokens;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;
import com.inspur.incloud.iauth.client.tokens.TokensApi;
import com.inspur.incloud.iauth.dao.user.model.UserModel;
import com.inspur.incloud.iauth.service.user.IUserService;

import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class TokensController implements TokensApi{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService iUserService;

	@ResponseBody
	public OperationResult<UserInforModel> checkTokenPower(
			@RequestHeader(name = "X-Auth-Token", required = true) String token,
			@RequestHeader(name = "X-Auth-Keep-Alive", required = false, defaultValue = "true") Boolean keepAlive) {
		OperationResult<UserInforModel> result = new OperationResult<UserInforModel>();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		logger.info("X-Auth-Token:" + token);
		logger.info("X-Auth-Keep-Alive:" + keepAlive);
		
		if(!token.equals(request.getHeader("X-Auth-Token"))) {
			logger.error("*********************************");
			logger.info("X-Auth-Token:" + token);
			logger.info("X-Auth-Token request:" + request.getHeader("X-Auth-Token"));
			logger.error("*********************************");
		}
		UserInforModel userInforModel = new UserInforModel();
		try {
			UserModel user = iUserService.queryUserById(token);
			if (null != user) {
				userInforModel.setAccount(user.getAccount());
				userInforModel.setName(user.getName());
				userInforModel.setEmail(user.getEmail());
				userInforModel.setId(user.getId());
				userInforModel.setIs_default(user.getIs_default());
				result.setResData(userInforModel);
				result.setFlag(true);
			} else {
				result.setFlag(false);
				result.setErrCode("20010");
			}
		} catch (CloudBusinessException e) {
			logger.error(e.getMessage(), e);
			result.setErrCode(e.getMsgCode());
			result.setFlag(false);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setFlag(false);
			return result;
		}

		return result;
	}

}
