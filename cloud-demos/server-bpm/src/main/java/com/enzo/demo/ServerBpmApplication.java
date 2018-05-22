package com.enzo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@MapperScan({ "com.enzo.demo.bpm.dao" })
public class ServerBpmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerBpmApplication.class, args);
	}
}
