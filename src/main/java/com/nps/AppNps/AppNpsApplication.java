package com.nps.AppNps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nps")
public class AppNpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppNpsApplication.class, args);


	}

}
