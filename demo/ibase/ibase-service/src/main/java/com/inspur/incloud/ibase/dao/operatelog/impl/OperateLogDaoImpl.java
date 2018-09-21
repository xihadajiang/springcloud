package com.inspur.incloud.ibase.dao.operatelog.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.inspur.incloud.common.dao.BaseDaoImpl;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.common.util.DbPageUtil;
import com.inspur.incloud.ibase.dao.operatelog.OperateLogDao;
import com.inspur.incloud.ibase.dao.operatelog.model.OperateLogModel;
import com.inspur.incloud.ibase.dao.user.UserDao;
import com.inspur.incloud.ibase.dao.user.model.UserModel;

@Repository("operateLogDao")
public class OperateLogDaoImpl extends BaseDaoImpl<OperateLogModel> implements OperateLogDao {

	public Serializable addOperateLog(OperateLogModel model) {
		save(model);
		return null;
	}

}
