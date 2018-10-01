### 目录结构说明


```
├─incloudmanager-parent----------------------顶层父项目POM文件，公共依赖
│  
├─incloudmanager-incloudmanager-utils--------工具类工程
│  │
├──├──incloudmanager-common------------------公共工具类
│  │
├──└──incloudmanager-filter----------------- 各服务统一认证过滤器
│
├─incloudmanager-api-gateway------------------服务网关
│
├─ibase---------------------------------基本模块
│  │
├──├──ibase-client---------------------------基本模块-客户端（给其它模块提供jar引用）
│  │
├──└──ibase-service--------------------------基本模块-服务端（提供REST服务）
│
├─iauth---------------------------------认证模块
│  │
├──├──ibase-client---------------------------认证模块-客户端（给其它模块提供jar引用）
│  │
├──└──ibase-service--------------------------认证模块-服务端（给其它模块提供jar引用）
│
├─icompute------------------------------计算模块

```

### 示例说明
```
    1、网关中心：http://127.0.0.1:7979
    2、网关中心--API文档：http://10.7.12.222:7979/swagger-ui.html
    3、iauth：http://127.0.0.1:8020
       token校验api curl -i -H "X-Auth-Token: qqq" http://127.0.0.1:8020/v1/auth/tokens
       网关调用     curl -i -H "X-Auth-Token: qqq" http://127.0.0.1:7979/iauth/v1/auth/tokens
    4、ibase：http://127.0.0.1:8030
       网关地址：http://127.0.0.1:7979/ibase
