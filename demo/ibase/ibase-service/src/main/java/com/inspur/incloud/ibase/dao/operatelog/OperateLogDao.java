package com.inspur.incloud.ibase.dao.operatelog;

import java.io.Serializable;

import com.inspur.incloud.common.dao.BaseDao;
import com.inspur.incloud.common.exception.CloudDBException;
import com.inspur.incloud.ibase.dao.operatelog.model.OperateLogModel;

public interface OperateLogDao extends BaseDao<OperateLogModel, String> {
	
	Serializable addOperateLog(OperateLogModel model)throws CloudDBException;

}
