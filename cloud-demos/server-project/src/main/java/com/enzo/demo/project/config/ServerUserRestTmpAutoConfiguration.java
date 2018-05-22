package com.enzo.demo.project.config;/**
 * Created by LENOVO on 2018/5/22.
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangyx
 * @desccription 用户服务rest配置
 * @date 2018-05-2018/5/22-15:34
 */
@Configuration
public class ServerUserRestTmpAutoConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate userRestTemplate(){
        return new RestTemplate();
    }
}
