package com.inspur.incloud.ibase.service.operatelog.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;
import com.inspur.incloud.ibase.dao.operatelog.OperateLogDao;
import com.inspur.incloud.ibase.dao.operatelog.model.OperateLogModel;
import com.inspur.incloud.ibase.service.operatelog.IOperateLogService;

@Service("operateLogService")

public class OperateLogServiceImpl implements IOperateLogService {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OperateLogDao operateLogDao;
	
	@Transactional(rollbackFor=Exception.class)
	public boolean addOperateLog(List<LogInfo> logInfos) throws CloudBusinessException {
		try {
			for(LogInfo logInfo:logInfos) {
				OperateLogModel model = new OperateLogModel();
				model.setDomainId(logInfo.getDomainId());
				model.setLogDate(new Date());
				model.setOrgId(logInfo.getDescription());
				model.setSysLogId(UUID.randomUUID().toString());
				model.setUserId(logInfo.getUserId());
				operateLogDao.save(model);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CloudBusinessException("", null ,e);
		}
		return true;
		
		
	}

}
