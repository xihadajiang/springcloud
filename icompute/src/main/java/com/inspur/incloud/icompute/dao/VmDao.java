package com.inspur.incloud.icompute.dao;

import java.io.Serializable;
import java.util.Map;

import com.inspur.incloud.icompute.model.VMModel;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

public interface VmDao {
	
	Serializable addVm(VMModel user);

	PageListBean<VMModel> listUsers(Map<String, Object> condition,
			final PageBean page);

}
