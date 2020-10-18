package com.dataworkshop.dataworkshopus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // Enable eureka client
public class DataWorkshopUsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataWorkshopUsApplication.class, args);
	}

}
