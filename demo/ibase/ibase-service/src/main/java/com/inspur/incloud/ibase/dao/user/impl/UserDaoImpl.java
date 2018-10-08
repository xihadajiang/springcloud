package com.inspur.incloud.ibase.dao.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.inspur.incloud.common.dao.BaseDaoImpl;
import com.inspur.incloud.common.exception.CloudDBException;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.ibase.dao.user.UserDao;
import com.inspur.incloud.ibase.dao.user.model.UserModel;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserModel, String> implements UserDao {

	@SuppressWarnings("unchecked")
	public PageListBean<UserModel> listUsers(Map<String, Object> condition,
			final PageBean page) throws CloudDBException {

		try {
			PageListBean<UserModel> pageList = null;
			final List<Object> args= new ArrayList<Object>();
			final StringBuffer hql = new StringBuffer();
			final StringBuffer countHql = new StringBuffer();
			countHql.append("select count(*) from UserModel where 1 = 1");
			hql.append("from UserModel where 1 = 1");
			if (condition.containsKey("name")) {
				String name = (String)condition.get("name");
				if(StringUtils.isNotEmpty(name)){
					hql.append(" and name = ?");
					countHql.append(" and name = ?");
					args.add(name);
				}
			}
			pageList = getPageList(hql.toString(), countHql.toString(), args, page);
	        return pageList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CloudDBException(e.getMessage(), e);
		}
	}

	public UserModel queryUserById(String id) throws CloudDBException {
		try {
			UserModel user = null;
			List<UserModel> list = null;
			list = (List<UserModel>) getHibernateTemplate().find("from UserModel where id = ? ", id);
			if (null != list && list.size() > 0) {
				user = list.get(0);
			}
			return user;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CloudDBException(e.getMessage(), e);
		}
		
	}

}
