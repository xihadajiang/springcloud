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
├──────├─────incloudmanager-task-------------------
│      │
├──────└─────incloudmanager-log--------------------
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
