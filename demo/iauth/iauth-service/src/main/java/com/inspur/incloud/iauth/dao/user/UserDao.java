package com.inspur.incloud.iauth.dao.user;

import java.io.Serializable;
import java.util.Map;

import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.iauth.dao.user.model.UserModel;

public interface UserDao {

	UserModel queryUserById(String id);

}
