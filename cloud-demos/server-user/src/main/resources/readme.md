# 用户微服务

---
> 本模块，演示微服务模块是如何以服务提供者(provider)的身份，向指定服务注册中心进行服务注册的.


## 配置信息
- 端口: 8101
- 服务ID: service-user
- 注册地址: http://localhost:8100/eureka/

## 依赖配置
- eureka 服务注册
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-netflix-eureka-server</artifactId>
</dependency>
```
- application 注解
```
@SpringBootApplication
# 用于server发现与注册
@EnableEurekaServer 
```


