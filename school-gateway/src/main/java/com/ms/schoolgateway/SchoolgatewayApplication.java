package com.ms.schoolgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SchoolgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolgatewayApplication.class, args);
	}

}
