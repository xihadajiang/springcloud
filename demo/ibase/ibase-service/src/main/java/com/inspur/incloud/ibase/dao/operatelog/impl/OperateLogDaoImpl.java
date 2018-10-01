package com.inspur.incloud.ibase.dao.operatelog.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.inspur.incloud.common.dao.BaseDaoImpl;
import com.inspur.incloud.common.exception.CloudDBException;
import com.inspur.incloud.ibase.dao.operatelog.OperateLogDao;
import com.inspur.incloud.ibase.dao.operatelog.model.OperateLogModel;

@Repository("operateLogDao")
public class OperateLogDaoImpl extends BaseDaoImpl<OperateLogModel, String> implements OperateLogDao {

	public Serializable addOperateLog(OperateLogModel model) {
		try {
			save(model);
		} catch (CloudDBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
