## icm使用pring Cloud 架构重构

### 项目介绍
```
功能点：
    完成云海架构替换和功能优化。
```
### 平台目录结构说明


```
├─incloudmanager-parent----------------------------父项目，公共依赖
│  
├─incloudmanager-incloudmanager-utils--------------微服务注册中心
│      │
├──────├─────incloudmanager-common-----------------公共工具类、服务启动脚本等
│      │
├──────├─────incloudmanager-task-------------------分布式任务
│      │
├──────└─────incloudmanager-log--------------------公共日志类
│
├─incloudmanager-eureka----------------------------微服务注册中心
│
├─incloudmanager-zuul------------------------------微服务网关
│
├─iauth--------------------------------------------微服务功能模块-认证
│
├─ibase--------------------------------------------微服务功能模块-1
│
├─icompute-----------------------------------------微服务功能模块-2
### 项目进度
```
已完成：
    1、完成incloudmanager-parent公共pom
    2、完成服务maven一键打包，服务脚本集成：start|stop|restart|status|dump
    3、完成incloudmanager-eureka注册中心服务启动

未完成：
    1、incloudmanager-common 工具类添加
    2、incloudmanager-task 分布式任务
    3、incloudmanager-log 公共日志
    4、incloudmanager-zuul微服务网关
    5、iauth、ibase、icompute
```
