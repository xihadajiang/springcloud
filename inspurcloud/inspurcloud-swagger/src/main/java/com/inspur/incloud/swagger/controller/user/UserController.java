package com.inspur.incloud.swagger.controller.user;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspur.incloud.swagger.common.JsonResult;
import com.inspur.incloud.swagger.controller.user.model.User;
import com.inspur.incloud.swagger.controller.user.model.User4Create;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(value="用户接口类")
@RestController
@EnableSwagger2
public class UserController {
	
	// 创建线程安全的Map
	static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());
	
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserById (@PathVariable(value = "id") Integer id){
		JsonResult r = new JsonResult();
		try {
			User user = users.get(id);
			r.setResult(user);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	
	@ApiOperation(value="添加用户", notes="根据参数创建用户信息")
	@ApiResponses({@ApiResponse(code = 201, message = "操作成功"),
        @ApiResponse(code = 401, message = "服务器内部异常"),
        @ApiResponse(code = 403, message = "权限不足"),
        @ApiResponse(code = 404, message = "资源未找到")})
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "body", dataType = "User4Create", name = "user4Create",value = "用户信息", required = true) })
	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody User4Create user4Create,  HttpServletRequest request){
		try {
			//TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@ApiOperation(value="删除用户", notes="删除用户")
	@ApiResponses({@ApiResponse(code = 201, message = "操作成功"),
        @ApiResponse(code = 401, message = "服务器内部异常"),
        @ApiResponse(code = 403, message = "权限不足"),
        @ApiResponse(code = 404, message = "资源未找到")})
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
	
	
	@ApiOperation(value="查询用户列表", notes="查询用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "name",value = "用户名称", required = true) })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	User4Create listUsers(@RequestParam String name) {
		//TODO
		return null;
    	
    }

}
