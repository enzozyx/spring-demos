# 项目模块
---
> 本模块作为服务提供者,向eureka注册中心注册服务,同时又是服务消费者,演示通过ribbon+restTemplate 消费service-user服务


## 配置信息
- 端口: 8103
- 服务ID: service-project
- 注册地址: http://localhost:8100/eureka/

## 依赖
```
# 服务注册依赖
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
# 服务消费依赖
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
# 通过@Configuration 向IOC容器注入 restTemplate
@Configuration
public class ServerUserRestTmpAutoConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate userRestTemplate(){
        return new RestTemplate();
    }
}
# 通过 service-id + uri + method + parameters 等信息消费被注册的服务
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public User queryUserByName(String name){
        // 服务ID:SERVICE-USER 
        // uri:/user/{name} 
        // method:GET 
        // 参数:name 
        // 返回数据类型: User.class
        return restTemplate.getForObject("http://SERVICE-USER/user/" + name , User.class);
    }
}
```


