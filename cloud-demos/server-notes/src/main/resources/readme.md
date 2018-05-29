# 笔记模块
---
> 该模块用来演示通过feign 接口方式来消费注册的服务

## 配置信息
- 端口: 8104
- 服务ID: server-notes
- 注册地址: `http://192.168.97.30:8100/eureka`

## 依赖配置
 ```
 # 服务注册
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
 # feign 
 <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-openfeign</artifactId>
 </dependency>
 # mybatis + postgres
 <dependency>
     <groupId>org.mybatis.spring.boot</groupId>
     <artifactId>mybatis-spring-boot-starter</artifactId>
     <version>1.3.2</version>
 </dependency>
 <dependency>
     <groupId>org.postgresql</groupId>
     <artifactId>postgresql</artifactId>
     <scope>runtime</scope>
 </dependency>
 
 # 注解
 @SpringBootApplication
 @EnableEurekaServer
 @EnableFeignClients
 @MapperScan({"com.enzo.demo.notes.dao"})
 
 # feign
 @FeignClient(value = "server-user")
 public interface IUserServiceProvider {
 
     @RequestMapping(value = "/user/{username}",method = RequestMethod.GET)
     User queryUser(@PathVariable(value = "username") String username);
 
 }
 # 使用
 @Autowired
 private IUserServiceProvider userProvider;
 ...
 User user = userProvider.queryUser(name);
 ```