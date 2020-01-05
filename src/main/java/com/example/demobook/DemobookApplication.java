package com.example.demobook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemobookApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemobookApplication.class, args);
	}

}
