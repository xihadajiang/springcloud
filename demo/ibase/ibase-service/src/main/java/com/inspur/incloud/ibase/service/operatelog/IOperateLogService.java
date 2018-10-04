package com.inspur.incloud.ibase.service.operatelog;


import java.util.List;

import com.inspur.incloud.common.exception.CloudBusinessException;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;


public interface IOperateLogService {

	boolean addOperateLog(List<LogInfo> logInfos) throws CloudBusinessException;

}
