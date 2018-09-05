package com.inspur.incloud.ibase.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.ibase.model.User4Create;
import com.inspur.incloud.ibase.model.UserModel;
import com.inspur.incloud.ibase.service.IUserService;
import com.inspur.incloud.model.PageBean;
import com.inspur.incloud.model.PageListBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses({@ApiResponse(code = 201, message = "操作成功"),
@ApiResponse(code = 204, message = "操作成功，无返回"),
@ApiResponse(code = 401, message = "未授权"),
@ApiResponse(code = 403, message = "权限不足"),
@ApiResponse(code = 404, message = "资源未找到")})
@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@ApiOperation(value="添加用户信息", notes="添加用户信息")
    @GetMapping(value = "/add")
	public String addUser(@RequestParam String name){
		UserModel user = new UserModel();
		String id = UUID.randomUUID().toString();
		user.setId(id);
		user.setAccount("lxg");
		user.setEmail("a@b.com");
		user.setAccount("lxg");
		user.setIs_default(0);
		user.setName(name);
		iUserService.addUser(user);
		return "success";
	}
    

	@ApiOperation(value="查询用户列表", notes="查询用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "name",value = "用户名称", required = true) })
    @GetMapping(value = "/list")
    PageListBean<UserModel> listUsers(@RequestParam String name) {
    	PageBean page = new PageBean();
    	page.setCurrentPage(1);
    	page.setPageSize(10);
    	Map<String, Object> condition = new HashMap<String, Object>();
    	condition.put("name", name);
    	
    	PageListBean<UserModel> pageLsit = iUserService.listUsers(condition, page);
    	
		return pageLsit;
    	
    }
	
    @ApiOperation(value="添加用户", notes="根据参数创建用户信息")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "body", dataType = "User4Create", name = "user4Create",value = "用户信息", required = true) })
	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody User4Create user4Create,  HttpServletRequest request){
		try {
			UserModel user = new UserModel();
			String id = UUID.randomUUID().toString();
			user.setId(id);
			user.setAccount(user4Create.getAccount());
			user.setIs_default(0);
			user.setName(user4Create.getName());
			iUserService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@ApiOperation(value="删除用户", notes="删除用户")
	@ApiResponses({@ApiResponse(code = 401, message = "覆盖类定义的响应码")})
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "userId",value = "用户ID", required = true) })
	@RequestMapping(value = "{userId}/action/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable String userId,  HttpServletRequest request){
		try {
			//TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
