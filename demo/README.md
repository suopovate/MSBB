# Msbb Demo

## 微服务相关
### 配置中心and注册中心(Nacos)
依赖：
```xml
<!--nacos start-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
<!--nacos end-->
```
配置：
```yaml
# 微服务引擎控制台: https://mse.console.aliyun.com
# Nacos帮助文档: https://nacos.io/zh-cn/docs/concepts.html
spring:
  cloud:
    nacos:
      discovery:
        # Nacos认证信息
        username: nacos
        password: nacos
        # 设置注册中心服务端地址
        server-addr: localhost:8848
      # 配置中心，如果无需使用配置中心，可以删除此部分配置
      # 配置客户端需要从服务端获取对应的配置文件：其格式为 :
      # prefix + '-' + ${spring.active.profile} + `.` + ${spring.cloud.nacos.config.file-extension}.
      # prefix 默认值为 ${spring.application.name}
      # 本例为 demo.yaml
      config:
        username: nacos
        password: nacos
        # 设置配置中心服务端地址
        server-addr: localhost:8848
        contextPath: /nacos
        file-extension: yaml
```
### RPC模块


## 数据库
mysql + mybatis + [mybatis plus]([https://mp.baomidou.com/guide/#%E7%89%B9%E6%80%A7](https://mp.baomidou.com/guide/#特性))
```
mybatis plus 是 mybatis 持久层框架的一个插件，属于对 mybatis 的无侵入增强，主要包括像: 
	1. 支持自动生成主键
	2. 类似于 Jpa，我们可以继承 mp 提供的一些基类接口，就可以让我们的 Mapper 具备一些基础的CRUD功能。
	3. 同时其提供物理分页功能，让我们可以简单的使用分页。
	4. 具体查询官网文档（全中文）
有一点学习成本，但是可以边用边学，同时也没有任何上手难度。
```

