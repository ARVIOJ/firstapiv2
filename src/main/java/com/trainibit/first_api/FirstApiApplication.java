package com.trainibit.first_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FirstApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstApiApplication.class, args);

	}


}
