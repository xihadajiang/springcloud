package com.inspur.incloud.ibase.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.inspur.incloud.dao.BaseDaoImpl;
import com.inspur.incloud.ibase.dao.UserDao;
import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;
import com.inspur.incloud.util.DbPageUtil;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserModel> implements UserDao {

	public Serializable addUser(UserModel user) {
		save(user);
		return 0;
	}

	public PageListBean<UserModel> listUsers(Map<String, Object> condition,
			final PageBean page) {

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
		pageList = (PageListBean<UserModel>) getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException {
                PageListBean list = DbPageUtil.getPageList(session, countHql.toString(), hql.toString(), page, args.toArray());
				return list;
			}
		});
        return pageList;
	}

}
