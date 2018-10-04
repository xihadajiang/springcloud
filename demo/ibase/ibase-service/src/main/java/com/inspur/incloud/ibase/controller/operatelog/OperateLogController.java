package com.inspur.incloud.ibase.controller.operatelog;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;
import com.inspur.incloud.ibase.client.operatelog.OperateLogApi;
import com.inspur.incloud.ibase.service.operatelog.IOperateLogService;

@RestController
public class OperateLogController implements OperateLogApi {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IOperateLogService iOperateService;
	
	@ResponseBody
	public Boolean addOperateLog(@RequestBody List<LogInfo> logInfos){
		try {
			iOperateService.addOperateLog(logInfos);
		} catch (CloudBusinessException e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return true;
	}
}
