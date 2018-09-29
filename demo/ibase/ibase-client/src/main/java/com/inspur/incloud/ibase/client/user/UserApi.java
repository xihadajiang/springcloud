package com.inspur.incloud.ibase.client.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.common.model.PageListBean;
import com.inspur.incloud.ibase.client.model.user.User4Create;
import com.inspur.incloud.ibase.client.model.user.UserApiModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Repository("userApi")
@FeignClient(name = "ibase-service", url = "${ibase-client.url}" )
@RequestMapping(value = "/v1/user")
@Api(tags = "用户接口")
public interface UserApi {
	
	@ApiOperation(value = "查询用户信息", notes = "通过用户ID查询用户信息")
	@ApiResponses({
			@ApiResponse(code = 10001, message = "用户不存在."),
			@ApiResponse(code = 10002, message = "这里写错误信息.")})
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", paramType = "query", required = true, dataType = "String", value = "用户的ID")})
	@RequestMapping(value = "/info", method= RequestMethod.GET)
	OperationResult<UserApiModel> queryUserById(
			@RequestParam(name = "id", required = true) String id);
	
	
	@ApiOperation(value = "查询用户列表", notes = "通过条件查询用户列表")
	@ApiResponses({
		@ApiResponse(code = 10001, message = "用户不存在."),
		@ApiResponse(code = 10002, message = "这里写错误信息.")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", paramType = "query", required = false, dataType = "String", value = "用户的ID"),
		@ApiImplicitParam(name = "pageSize", paramType = "query", required = false, defaultValue = "10", dataType = "Integer", value = "用户的ID"),
		@ApiImplicitParam(name = "currentPage", paramType = "query", required = false, defaultValue = "1", dataType = "Integer", value = "用户的ID")
	})
	@RequestMapping(value = "/list", method= RequestMethod.GET)
    OperationResult<PageListBean<UserApiModel>> listUsers(
    		@RequestParam(name="name", required=false) String name,
    		@RequestParam(name="pageSize", required=false, defaultValue = "10") Integer pageSize,
    		@RequestParam(name="currentPage", required=false, defaultValue = "1") Integer currentPage);
	
	@ApiOperation(value = "新建用户", notes = "新建用户信息")
	@ApiResponses({
		@ApiResponse(code = 10001, message = "用户不存在."),
		@ApiResponse(code = 10002, message = "这里写错误信息.")
	})
	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
	OperationResult<UserApiModel> add(@ApiParam @RequestBody User4Create user4Create);
	
	@ApiOperation(value = "删除用户", notes = "删除用户信息")
	@ApiResponses({
		@ApiResponse(code = 10001, message = "用户不存在."),
		@ApiResponse(code = 10002, message = "这里写错误信息.")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", paramType = "path", required = true, dataType = "String", value = "用户ID")
	})
	@RequestMapping(value = "{userId}/action/delete", method = RequestMethod.DELETE)
	OperationResult<UserApiModel> delete(@PathVariable(name = "userId") String userId);
	
	@ApiOperation(value = "更新用户", notes = "更新用户信息")
	@ApiResponses({
		@ApiResponse(code = 10001, message = "用户不存在."),
		@ApiResponse(code = 10002, message = "这里写错误信息.")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", paramType = "path", required = true, dataType = "String", value = "用户ID")
	})
	@RequestMapping(value = "{userId}/action/update", method = RequestMethod.PUT)
	OperationResult<UserApiModel> update(@ApiParam @RequestBody User4Create user4Create,@PathVariable(name = "userId") String userId);
}
