package com.kingbreak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kingbreak.mapper*")
@SpringBootApplication
public class RegistrationOfMigrantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationOfMigrantsApplication.class, args);
	}

}
