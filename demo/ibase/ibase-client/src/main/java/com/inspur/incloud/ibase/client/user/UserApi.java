package com.inspur.incloud.ibase.client.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

@Service("userApi")
@FeignClient(name = "ibase-service", url = "${ibase-client.url}" )
@RequestMapping(value = "/v1")
@Api(tags = "用户接口")
public interface UserApi {
	
	@ApiOperation(value = "查询用户信息", notes = "通过用户ID查询用户信息")
	@ApiResponses({
			@ApiResponse(code = 1, message = "IBASE_QUERY_USER_BY_ID_DB_ERROR:数据库错误."),
			@ApiResponse(code = 2, message = "IBASE_QUERY_USER_BY_ID_EXCEPTION：用户查询错误.")})
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", paramType = "path", required = true, dataType = "String", value = "用户的ID")})
	@RequestMapping(value = "/users/{userId}", method= RequestMethod.GET)
	OperationResult<UserApiModel> queryUserById(@PathVariable(name = "userId") String userId);
	
	
	@ApiOperation(value = "查询用户列表", notes = "通过条件查询用户列表")
	@ApiResponses({
		@ApiResponse(code = 1, message = "IBASE_QUERY_USER_LIST_DB_ERROR:查询用户列表数据库错误."),
		@ApiResponse(code = 2, message = "IBASE_QUERY_USER_LIST_EXCEPTION:查询用户列表错误.")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", paramType = "query", required = false, dataType = "String", value = "用户的ID"),
		@ApiImplicitParam(name = "pageSize", paramType = "query", required = false, defaultValue = "10", dataType = "Integer", value = "用户的ID"),
		@ApiImplicitParam(name = "currentPage", paramType = "query", required = false, defaultValue = "1", dataType = "Integer", value = "用户的ID")
	})
	@RequestMapping(value = "/users", method= RequestMethod.GET)
    OperationResult<PageListBean<UserApiModel>> listUsers(
    		@RequestParam(name="name", required=false) String name,
    		@RequestParam(name="pageSize", required=false, defaultValue = "10") Integer pageSize,
    		@RequestParam(name="currentPage", required=false, defaultValue = "1") Integer currentPage);
	
	@ApiOperation(value = "新建用户", notes = "新建用户信息")
	@ApiResponses({
		@ApiResponse(code = 1, message = "IBASE_ADD_USER_PARAM_ERROR:新建用户参数错误."),
		@ApiResponse(code = 2, message = "IBASE_ADD_USER_EXCEPTION:新建用户错误.")
	})
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	OperationResult<UserApiModel> add(@ApiParam @RequestBody User4Create user4Create);
	
	@ApiOperation(value = "删除用户", notes = "删除用户信息")
	@ApiResponses({
		@ApiResponse(code = 1, message = "IBASE_USER_NOT_FOUND_ERROR:用户不存在."),
		@ApiResponse(code = 2, message = "IBASE_DELETE_USER_EXCEPTION:删除用户错误.")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", paramType = "path", required = true, dataType = "String", value = "用户ID")
	})
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	OperationResult<UserApiModel> delete(@PathVariable(name = "userId") String userId);
	
	@ApiOperation(value = "更新用户", notes = "更新用户信息")
	@ApiResponses({
		@ApiResponse(code = 1, message = "IBASE_USER_NOT_FOUND_ERROR:用户不存在."),
		@ApiResponse(code = 2, message = "IBASE_UPDATE_USER_EXCEPTION:更新用户错误.")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", paramType = "path", required = true, dataType = "String", value = "用户ID")
	})
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	OperationResult<UserApiModel> update(@ApiParam @RequestBody User4Create user4Create,@PathVariable(name = "userId") String userId);
}
