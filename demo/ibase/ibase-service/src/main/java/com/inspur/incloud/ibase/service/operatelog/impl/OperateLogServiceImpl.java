package com.inspur.incloud.ibase.service.operatelog.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspur.incloud.common.UserSession;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.common.message.operatelog.OperateLogCodeMessageUtil;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;
import com.inspur.incloud.ibase.dao.operatelog.OperateLogDao;
import com.inspur.incloud.ibase.dao.operatelog.model.OperateLogModel;
import com.inspur.incloud.ibase.service.operatelog.IOperateLogService;

@Service("operateLogService")
@Transactional()
public class OperateLogServiceImpl implements IOperateLogService {
	
	@Autowired
	private OperateLogDao operateLogDao;

	public boolean addOperateLog(UserSession user, LogInfo logInfo) throws CloudBusinessException {
		try {
			OperateLogModel model = new OperateLogModel();
			model.setDomainId(user.getDomainId());
			model.setLogDate(new Date());
			model.setOrgId(user.getOrgId());
			model.setSysLogId(UUID.randomUUID().toString());
			model.setUserId(user.getUserId());
			operateLogDao.save(model);
		} catch (Exception e) {
			List<String> args = new ArrayList<String>();
			args.add("test");
			throw new CloudBusinessException("00000002", args);
		}
		return true;
		
		
	}

}
