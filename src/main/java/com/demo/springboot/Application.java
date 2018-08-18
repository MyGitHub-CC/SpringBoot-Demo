package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/***
 * 1.创建 Application.java
 * @author lenovo
 *
 */
//其注解 @SpringBootApplication 表示这是一个SpringBoot应用，运行其主方法就会启动tomcat,默认端口是8080
@SpringBootApplication
//新加@ServletComponentScan注解，并且继承SpringBootServletInitializer 。
@ServletComponentScan
public class Application extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}