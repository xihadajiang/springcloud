package com.inspur.incloud.ibase.dao.operatelog.impl;

import org.springframework.stereotype.Repository;

import com.inspur.incloud.common.dao.BaseDaoImpl;
import com.inspur.incloud.ibase.dao.operatelog.OperateLogDao;
import com.inspur.incloud.ibase.dao.operatelog.model.OperateLogModel;

@Repository("operateLogDao")
public class OperateLogDaoImpl extends BaseDaoImpl<OperateLogModel, String> implements OperateLogDao {


}
