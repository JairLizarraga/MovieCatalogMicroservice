package com.example.mif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MifApplication {

	public static void main(String[] args) {
		SpringApplication.run(MifApplication.class, args);
	}

}
