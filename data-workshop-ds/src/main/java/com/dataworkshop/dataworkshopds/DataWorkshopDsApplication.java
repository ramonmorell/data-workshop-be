package com.dataworkshop.dataworkshopds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Enable Eureka server
public class DataWorkshopDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataWorkshopDsApplication.class, args);
	}

}
