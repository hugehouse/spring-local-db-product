package com.test.whatap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class WhatapApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatapApplication.class, args);
	}

}
