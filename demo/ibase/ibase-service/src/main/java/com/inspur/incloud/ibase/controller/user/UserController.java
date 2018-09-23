package com.inspur.incloud.ibase.controller.user;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.ibase.client.model.user.User4Create;
import com.inspur.incloud.ibase.client.model.user.UserApiModel;
import com.inspur.incloud.ibase.client.user.UserApi;
import com.inspur.incloud.ibase.dao.user.model.UserModel;
import com.inspur.incloud.ibase.service.user.IUserService;

@RestController
@RequestMapping("/v1/user")
public class UserController implements UserApi {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/info", method= RequestMethod.GET)
	@ResponseBody
	public OperationResult<UserApiModel> queryUserById(@RequestParam String id,
			HttpServletRequest request) {
		OperationResult<UserApiModel> result = new OperationResult<UserApiModel>();
		String token = request.getHeader("token");
		// userSession 通过api 网关 转发过来的请求肯定不为null，模块间调用，有可能为null
		// UserSession userSession = (UserSession) request.getAttribute("userSession")
		UserApiModel apiModel = new UserApiModel();
		if (StringUtils.isEmpty(token)) {
			apiModel.setName("ibase token null");
		}
		try {
			UserModel user = iUserService.queryUserById(id);
	    	if (null != user) {
	    		apiModel.setAccount(user.getAccount());
	    		apiModel.setName(user.getName());
	    		apiModel.setEmail(user.getEmail());
	    		apiModel.setId(user.getId());
	    		apiModel.setIs_default(user.getIs_default());
	    	}
	    	result.setResData(apiModel);
	    	result.setFlag(true);
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		result.setFlag(false);
    		return result;
    	}
    	
		return result;
    }
	
    @RequestMapping(value = "/list", method= RequestMethod.GET)
	@ResponseBody
    OperationResult listUsers(@RequestParam String name) {
		OperationResult result = new OperationResult();
    	PageBean page = new PageBean();
    	page.setCurrentPage(1);
    	page.setPageSize(10);
    	Map<String, Object> condition = new HashMap<String, Object>();
    	condition.put("name", name);
    	try {
    		PageListBean<UserModel> pageLsit = iUserService.listUsers(condition, page);
    		result.setFlag(true);
    		result.setResData(pageLsit);
    		return result;
    	} catch (CloudBusinessException e) {
    		logger.error(e.getMessage(), e);
    		result.setFlag(false);
    		Locale lang = Locale.US;
    		String test = messageSource.getMessage("lxg", e.getParamList().toArray(), lang);
    		result.setErrMessageEn(test);
    		return result;
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		result.setFlag(false);
    		Locale lang = Locale.US;
    		String test = messageSource.getMessage("lxg",null, lang);
    		result.setErrMessageEn(test);
    		return result;
    	}
    	
    	
    }
	
	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody User4Create user4Create,  HttpServletRequest request){
		try {
			UserModel user = new UserModel();
			String id = UUID.randomUUID().toString();
			user.setId(id);
			user.setAccount(user4Create.getAccount());
			user.setIs_default(0);
			user.setName(user4Create.getName());
			user.setEmail(user4Create.getEmail());
			iUserService.addUser(user);
		} catch (CloudBusinessException e) {
			logger.error(e.getMessage(), e);
			return "fail";
		} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		return "fail";
    	}
		return "success";
	}
	
	@RequestMapping(value = "{userId}/action/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable String userId,  HttpServletRequest request){
		try {
			logger.debug("begin the to delete user by id: " + userId);
			iUserService.delete(userId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping(value = "{userId}/action/update", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody User4Create user4Create, @PathVariable String userId,
			HttpServletRequest request){
		try {
			logger.debug("begin the to update user by id: " + userId);
			iUserService.updateUser(userId, user4Create);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "fail";
		}
		return "success";
	}
}
