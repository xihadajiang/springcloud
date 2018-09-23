package com.inspur.incloud.iauth.controller.tokens;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;
import com.inspur.incloud.iauth.client.tokens.TokensApi;
import com.inspur.incloud.iauth.dao.user.model.UserModel;
import com.inspur.incloud.iauth.service.user.IUserService;

@RestController
@RequestMapping("/v1/auth")
public class TokensController implements TokensApi {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value = "/tokens", method= RequestMethod.GET)
	@ResponseBody
	public OperationResult<UserInforModel> checkTokenPower(@RequestHeader(value = "X-Auth-Token", required = true) String token,
			@RequestHeader(value = "X-Auth-Keep-Alive", required = false, defaultValue = "true") Boolean keepAlive) {
		OperationResult<UserInforModel> result = new OperationResult<UserInforModel>();		
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
	    		result.setErrCode("10200");
	    	}
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		result.setFlag(false);
    		return result;
    	}
    	
		return result;
    }
}
