package com.dataworkshop.dataworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // Enable eureka client
public class DataWorkshopSeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataWorkshopSeApplication.class, args);
	}

}
