package com.inspur.incloud.icompute.service;

import java.util.Map;

import com.inspur.incloud.icompute.model.VMModel;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

public interface IVmService {

	String addVm(VMModel user, String userId);

	PageListBean<VMModel> listUsers(Map<String, Object> condition,
			PageBean page);

}
