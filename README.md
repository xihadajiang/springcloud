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


