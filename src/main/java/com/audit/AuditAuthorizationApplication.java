package com.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@CrossOrigin("*")
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class AuditAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditAuthorizationApplication.class, args);
	}

}
