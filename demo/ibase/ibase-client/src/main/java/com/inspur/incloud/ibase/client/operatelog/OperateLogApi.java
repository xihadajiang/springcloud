package com.inspur.incloud.ibase.client.operatelog;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.inspur.incloud.ibase.client.BaseApi;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;

@Repository("operateLogApi")
public interface OperateLogApi extends BaseApi{
	
	@RequestMapping(value = "/operatelog/action/add", method = RequestMethod.POST)
	String addOperateLog(@RequestBody LogInfo logInfo,  HttpServletRequest request);
}
