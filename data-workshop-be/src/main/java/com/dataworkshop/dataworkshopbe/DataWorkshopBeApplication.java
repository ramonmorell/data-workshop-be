package com.dataworkshop.dataworkshopbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // Enable eureka client
public class DataWorkshopBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataWorkshopBeApplication.class, args);
	}

}
