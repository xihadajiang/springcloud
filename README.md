## XX测试项目

### 项目介绍
```
功能点：
    功能优化。
```
### 平台目录结构说明


```
├─incloudmanager-parent----------------------------父项目，公共依赖
│  
├─incloudmanager-incloudmanager-utils--------------微服务注册中心
│      │
├──────├─────incloudmanager-common-----------------公共工具类、服务启动脚本等
│      │
├──────├─────incloudmanager-shell----------------- 统一服务启动脚本
│      │
├──────└────
│
├─incloudmanager-eureka----------------------------微服务注册中心
│
├─incloudmanager-api-gateway-----------------------微服务网关
│
├─iauth--------------------------------------------微服务功能模块-认证
│
├─ibase--------------------------------------------微服务功能模块-1
│
├─icompute-----------------------------------------微服务功能模块-2

```
### 项目进度
```
已完成：
    1、完成incloudmanager-parent公共pom
    2、完成服务maven一键打包，服务脚本集成：start|stop|restart|status|dump
    3、完成incloudmanager-eureka注册中心服务启动
    4、incloudmanager-zuul微服务网关启动，并配置了服务路由转发规则
    5、iauth、ibase、icompute服务注册启动，ibase实现了数据库操作
    6、通过Feign方式icompute服务调用ibase，并通过Hystrix开启熔断策略

未完成：
    1、给统一认证过滤器
    2、错误时统一JSON格式输出
    3、数据库配置事务
```

### 示例说明
```
    1、注册中心：http://10.7.12.222:8761   root/root
    2、网关中心：http://10.7.12.222:7979
    3、iauth：http://10.7.12.222:8040 http://10.7.12.222:8055
       token校验api curl -i -H "auth-token:ssss" http://10.7.12.222:8040/token/check
       用户token查询 curl -i  http://10.7.12.222:8040/users/token?tokenId=ssss
    4、网关负载均衡示例： curl -i 10.7.12.222:7979/iauth/users/token?tokenId=ssss
    5、ibase：
        服务地址：http://10.7.12.222:8030
        新增用户示例： curl http://10.7.12.222:8030/add?name=icm
	查询用户列表示例： curl http://10.7.12.222:8030/list?name=lxg
    6、icompute：
        服务地址：http://10.7.12.222:8050
        根据用户id用Feign方式去ibase查询用户名称并保存虚拟机信息示例：curl http://10.7.12.222:8050/vm/add?userId=1
    7、熔断演示方法：
        停掉ibase服务，然后执行根据用户id查询用户名称并保存虚拟机信息示例
			


```
