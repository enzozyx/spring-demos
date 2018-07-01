package com.enzo.demo.common;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
@MapperScan({"com.enzo.demo.notes.dao"})
@Hystrix
public class ServerNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerNotesApplication.class, args);
	}
}
