package com.inspur.incloud.icompute.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.icompute.model.VMModel;
import com.inspur.incloud.icompute.service.IVmService;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

import io.swagger.annotations.ApiOperation;

@RestController
public class VmController {

	@Autowired
	private IVmService iVmService;
	
	@ApiOperation(value="添加用户信息", notes="添加用户信息")
    @GetMapping(value = "/vm/add")
	public String addVm(@RequestParam String userId){
		VMModel vm = new VMModel();
		String id = UUID.randomUUID().toString();
		vm.setId(id);
		vm.setName("lxg");
		vm.setUserId(null);
		String result = iVmService.addVm(vm, userId);
		return result;
	}
    
    @GetMapping(value = "/list")
    PageListBean<VMModel> listUsers(@RequestParam String name) {
    	PageBean page = new PageBean();
    	page.setCurrentPage(1);
    	page.setPageSize(10);
    	Map<String, Object> condition = new HashMap<String, Object>();
    	condition.put("name", name);
    	
    	PageListBean<VMModel> pageLsit = iVmService.listUsers(condition, page);
    	
		return pageLsit;
    	
    }
}
