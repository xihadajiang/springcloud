package com.inspur.incloud.ibase.service.operatelog;


import com.inspur.incloud.common.UserSession;
import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;

public interface IOperateLogService {

	boolean addOperateLog(UserSession user, LogInfo logInfo) throws CloudBusinessException;

}
