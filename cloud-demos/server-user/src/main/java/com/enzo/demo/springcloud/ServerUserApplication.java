package com.enzo.demo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@MapperScan({ "com.enzo.demo.springcloud.server.user.dao" })
public class ServerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerUserApplication.class, args);
	}
}
