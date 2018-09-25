package com.inspur.incloud.ibase.controller.operatelog;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.common.UserSession;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;
import com.inspur.incloud.ibase.client.operatelog.OperateLogApi;
import com.inspur.incloud.ibase.service.operatelog.IOperateLogService;

@RestController
public class OperateLogController implements OperateLogApi {
	
	private Logger logger =  LoggerFactory.getLogger(OperateLogController.class);

	@Autowired
	private IOperateLogService iOperateService;
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseBody
	public String addOperateLog(@RequestBody LogInfo logInfo,  HttpServletRequest request){
		try {
			logger.error("+++++++++++++++++++++++++");
			UserSession userSession = (UserSession) request.getAttribute("userSessioon");
			if(null == userSession) {
				userSession = new UserSession();
				userSession.setDomainId("domainId");
				userSession.setOrgId("orgId");
				userSession.setUserId("userId");
			}
			iOperateService.addOperateLog(userSession, logInfo);
		} catch (CloudBusinessException e) {
			logger.error("----------------------------");
			return "fail";
		}
		return "success";
	}
}
