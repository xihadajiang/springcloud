package com.inspur.incloud.icompute.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspur.incloud.ibase.api.model.UserApiModel;
import com.inspur.incloud.ibase.api.service.IBaseApi;
import com.inspur.incloud.icompute.dao.VmDao;
import com.inspur.incloud.icompute.model.VMModel;
import com.inspur.incloud.icompute.service.IVmService;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

@Service
public class VmServiceImpl implements IVmService {

	@Autowired
	private VmDao vmDao;
	
	@Autowired
    IBaseApi iBaseApi;

	@Transactional
	public String addVm(VMModel vm, String userId) {
		UserApiModel apiModel = null;
		apiModel = iBaseApi.queryUserById(userId);
		String name = apiModel.getName();
		if ("I am tired, i need a wake".equals(name)) {
			return name;
		}
		vm.setUserId(name);
		vmDao.addVm(vm);
		return "success";
		
	}

	@Transactional
	public PageListBean<VMModel> listUsers(Map<String, Object> condition,
			PageBean page) {
		// TODO Auto-generated method stub
		return vmDao.listUsers(condition, page);
	}

}
