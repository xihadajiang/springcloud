package com.inspur.incloud.ibase.client.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.common.util.feign.FeignConfig;
import com.inspur.incloud.ibase.client.model.user.User4Create;
import com.inspur.incloud.ibase.client.model.user.UserApiModel;

@Repository("userApi")
@FeignClient(name = "ibase-service", url = "${ibase-client.url}" ,configuration = FeignConfig.class)
@RequestMapping(value = "/v1")
public interface UserApi {

	@RequestMapping(value = "/user/info", method= RequestMethod.GET)
	OperationResult<UserApiModel> queryUserById(@RequestParam(value = "id", required = true) String id);
	
	@RequestMapping(value = "/list", method= RequestMethod.GET)
    OperationResult<PageListBean<UserApiModel>> listUsers(
    		@RequestParam(value="name", required=false) String name,
    		@RequestParam(value="pageSize", required=true, defaultValue = "10") Integer pageSize,
    		@RequestParam(value="currentPage", required=true, defaultValue = "1") String currentPage);
	
	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
	OperationResult<UserApiModel> add(@RequestBody User4Create user4Create);
	
	@RequestMapping(value = "{userId}/action/delete", method = RequestMethod.DELETE)
	OperationResult<UserApiModel> delete(@PathVariable String userId);
	
	@RequestMapping(value = "{userId}/action/update", method = RequestMethod.PUT)
	OperationResult<UserApiModel> update(@RequestBody User4Create user4Create, @PathVariable String userId);
}
