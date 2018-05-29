package com.enzo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.enzo.demo.code.dao"})
public class CodePluginApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodePluginApplication.class, args);
	}
}
