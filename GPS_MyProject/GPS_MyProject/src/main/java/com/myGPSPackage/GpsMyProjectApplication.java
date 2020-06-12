package com.myGPSPackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.myGPSPackage.resource", "com.myGPSPackage.repository"})
//@EntityScan(basePackages= {"com.myGPSPackage.models"})
public class GpsMyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpsMyProjectApplication.class, args);
	}

}
