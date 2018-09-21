package com.inspur.incloud.ibase.dao.operatelog;

import java.io.Serializable;

import com.inspur.incloud.ibase.dao.operatelog.model.OperateLogModel;

public interface OperateLogDao {
	
	Serializable addOperateLog(OperateLogModel model);

}
