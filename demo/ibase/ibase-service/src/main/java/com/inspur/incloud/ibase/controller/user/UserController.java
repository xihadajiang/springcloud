package com.inspur.incloud.ibase.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.common.message.errorcode.ErrorCodeMessageUtil;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.common.UserSession;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;
import com.inspur.incloud.ibase.client.model.user.User4Create;
import com.inspur.incloud.ibase.client.model.user.UserApiModel;
import com.inspur.incloud.ibase.client.user.UserApi;
import com.inspur.incloud.ibase.dao.user.model.UserModel;
import com.inspur.incloud.ibase.service.user.IUserService;
import com.inspur.incloud.log.SyslogService;

@RestController
public class UserController implements UserApi {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private SyslogService logService;
	
	@ResponseBody
	public OperationResult<UserApiModel> queryUserById(@PathVariable(name = "userId") String userId) {
		OperationResult<UserApiModel> result = new OperationResult<UserApiModel>();
		// userSession 通过api 网关 转发过来的请求肯定不为null，模块间调用，有可能为null
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
		String lang = request.getHeader("X-Accept-Language");
		UserSession userSession = (UserSession) request.getAttribute("userSession");
		if(userSession != null) {
			logger.info("uerSession info is :" + userSession.toString());
		}
		try {
			UserApiModel apiModel = new UserApiModel();
			UserModel user = iUserService.queryUserById(userId);
	    	if (null != user) {
	    		apiModel.setAccount(user.getAccount());
	    		apiModel.setName(user.getName());
	    		apiModel.setEmail(user.getEmail());
	    		apiModel.setId(user.getId());
	    		apiModel.setIs_default(user.getIs_default());
	    	}
	    	result.setResData(apiModel);
	    	result.setFlag(true);
    		return result;
    	} catch (CloudBusinessException e) {
    		logger.error(e.getMessage(), e);
    		result.setFlag(false);
    		String message  = ErrorCodeMessageUtil.getMessage(e.getMsgCode(), e.getParamList(), lang);
    		result.setErrMessage(message);
    		result.setErrCode(e.getMsgCode());
    		return result;
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		String message  = ErrorCodeMessageUtil.getMessage("IBASE_QUERY_USER_BY_ID_EXCEPTION", null, lang);
    		result.setErrCode("IBASE_QUERY_USER_BY_ID_EXCEPTION");
    		result.setErrMessage(message);
    		return result;
    	}
    }
	
	@ResponseBody
    public OperationResult<PageListBean<UserApiModel>> listUsers(
    		@RequestParam(name="name", required=false) String name,
    		@RequestParam(name="pageSize", required=false, defaultValue = "10") Integer pageSize,
    		@RequestParam(name="currentPage", required=false, defaultValue = "1") Integer currentPage) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
		String lang = request.getHeader("X-Accept-Language");
		UserSession userSession = (UserSession) request.getAttribute("userSession");
		if(userSession != null) {
			logger.info("uerSession info is :" + userSession.toString());
		}
		OperationResult<PageListBean<UserApiModel>> result = new OperationResult<PageListBean<UserApiModel>>();
    	PageBean page = new PageBean();
    	page.setCurrentPage(currentPage);
    	page.setPageSize(pageSize);
    	Map<String, Object> condition = new HashMap<String, Object>();
    	if(StringUtils.isNotEmpty(name)) {
    	    condition.put("name", name);
    	}
    	try {
    		PageListBean<UserModel> pageLsit = iUserService.listUsers(condition, page);
    		result.setFlag(true);
    		List<UserModel> userList = pageLsit.getData();
    		List<UserApiModel> userApiList = new ArrayList<UserApiModel>();
    		for (UserModel user : userList) {
    			UserApiModel userApi = new UserApiModel();
    			userApi.setAccount(user.getAccount());
    			userApi.setEmail(user.getEmail());
    			userApi.setId(user.getId());
    			userApi.setIs_default(user.getIs_default());
    			userApi.setName(user.getName());
    			userApiList.add(userApi);
    		}
    		result.setResData(new PageListBean<UserApiModel>(pageLsit.getTotal(), pageLsit.getPageSize(), pageLsit.getCurrentPage(), userApiList));
    		return result;
    	} catch (CloudBusinessException e) {
    		logger.error(e.getMessage(), e);
    		result.setFlag(false);
    		String message  = ErrorCodeMessageUtil.getMessage(e.getMsgCode(), e.getParamList(), lang);
    		result.setErrMessage(message);
    		result.setErrCode(e.getMsgCode());
    		return result;
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		result.setFlag(false);
    		String message  = ErrorCodeMessageUtil.getMessage("IBASE_QUERY_USER_LIST_EXCEPTION", null, lang);
    		result.setErrCode("IBASE_QUERY_USER_LIST_EXCEPTION");
    		result.setErrMessage(message);
    		return result;
    	}
    	
    	
    }
	
	@ResponseBody
	public OperationResult<UserApiModel> add(@RequestBody User4Create user4Create){
		OperationResult<UserApiModel> result = new OperationResult<UserApiModel>();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
		String lang = request.getHeader("X-Accept-Language");
		UserSession userSession = (UserSession) request.getAttribute("userSession");
		if(userSession != null) {
			logger.info("uerSession info is :" + userSession.toString());
		}
		try {
			UserModel user = new UserModel();
			UserApiModel userApi = new UserApiModel();
			String id = UUID.randomUUID().toString();
			user.setId(id);
			user.setAccount(user4Create.getAccount());
			user.setIs_default(0);
			user.setName(user4Create.getName());
			user.setEmail(user4Create.getEmail());
			iUserService.addUser(user);
			userApi.setId(id);
			userApi.setAccount(user4Create.getAccount());
			userApi.setIs_default(0);
			userApi.setName(user4Create.getName());
			userApi.setEmail(user4Create.getEmail());
			result.setResData(userApi);
			result.setFlag(true);
			logService.addOperlog(userSession,true,"USER","USER.ADD",new Object[] {user4Create.getAccount()},"");
		} catch (CloudBusinessException e) {
			logger.error(e.getMessage(), e);
			String message  = ErrorCodeMessageUtil.getMessage(e.getMsgCode(), e.getParamList(), lang);
    		result.setErrMessage(message);
    		result.setErrCode(e.getMsgCode());
			result.setFlag(false);
			logService.addOperlog(userSession,false,"USER","USER.ADD",new Object[] {user4Create.getAccount()},"");
			return result;
		} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		String message  = ErrorCodeMessageUtil.getMessage("IBASE_ADD_USER_EXCEPTION", null, lang);
    		result.setErrCode("IBASE_ADD_USER_EXCEPTION");
    		result.setErrMessage(message);
    		result.setFlag(false);
    		logService.addOperlog(userSession,false,"USER","USER.ADD",new Object[] {user4Create.getAccount()},"");
    		return result;
    	}
		return result;
	}
	
	@ResponseBody
	public OperationResult<UserApiModel> delete(@PathVariable(name = "userId") String userId){
		logger.debug("begin to delete user with userId: " + userId);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
		String lang = request.getHeader("X-Accept-Language");
		UserSession userSession = (UserSession) request.getAttribute("userSession");
		if(userSession != null) {
			logger.info("uerSession info is :" + userSession.toString());
		}
		OperationResult<UserApiModel> result = new OperationResult<UserApiModel>();
		try {
			logger.debug("begin the to delete user by id: " + userId);
			iUserService.delete(userId);
			result.setFlag(true);
			logger.debug("end to delete user with userId: " + userId);
	    	logService.addOperlog(userSession,true,"USER","USER.DELETE",new Object[] {userId},"");
			return result;
		} catch (CloudBusinessException e) {
			logger.error(e.getMessage(), e);
			String message  = ErrorCodeMessageUtil.getMessage(e.getMsgCode(), e.getParamList(), lang);
    		result.setErrMessage(message);
    		result.setErrCode(e.getMsgCode());
			result.setFlag(false);
			logService.addOperlog(userSession,false,"USER","USER.DELETE",new Object[] {userId},"");
			return result;
		}  catch (Exception e) {
			logger.error(e.getMessage(), e);
			String message  = ErrorCodeMessageUtil.getMessage("IBASE_DELETE_USER_EXCEPTION", null, lang);
    		result.setErrCode("IBASE_DELETE_USER_EXCEPTION");
    		result.setErrMessage(message);
    		result.setFlag(false);
    		logService.addOperlog(userSession,false,"USER","USER.DELETE",new Object[] {userId},"");
			return result;
		}
	}
	
	@ResponseBody
	public OperationResult<UserApiModel> update(@RequestBody User4Create user4Create, @PathVariable(name = "userId") String userId){
		logger.debug("begin to update user with userId: " + userId);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
		String lang = request.getHeader("X-Accept-Language");
		UserSession userSession = (UserSession) request.getAttribute("userSession");
		if(userSession != null) {
			logger.info("uerSession info is :" + userSession.toString());
		}
		OperationResult<UserApiModel> result = new OperationResult<UserApiModel>();
		try {
			logger.debug("begin the to update user by id: " + userId);
			iUserService.updateUser(userId, user4Create);
			result.setFlag(true);
			logger.debug("end to update user with userId: " + userId);
	    	logService.addOperlog(userSession,true,"USER","USER.UPDATE",new Object[] {userId},"");
			return result;
		} catch (CloudBusinessException e) {
			logger.error(e.getMessage(), e);
			String message  = ErrorCodeMessageUtil.getMessage(e.getMsgCode(), e.getParamList(), lang);
    		result.setErrMessage(message);
    		result.setErrCode(e.getMsgCode());
			result.setFlag(false);
			logService.addOperlog(userSession,false,"USER","USER.UPDATE",new Object[] {userId},"");
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String message  = ErrorCodeMessageUtil.getMessage("IBASE_UPDATE_USER_EXCEPTION", null, lang);
    		result.setErrCode("IBASE_UPDATE_USER_EXCEPTION");
    		result.setErrMessage(message);
    		result.setFlag(false);
    		logService.addOperlog(userSession,false,"USER","USER.UPDATE",new Object[] {userId},"");
			return result;
		}
		
	}
}
