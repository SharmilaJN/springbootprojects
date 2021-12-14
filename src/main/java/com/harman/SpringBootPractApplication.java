package com.harman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "controller")
@ComponentScan(basePackages="com.harman")

public class SpringBootPractApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPractApplication.class, args);
	}

}
