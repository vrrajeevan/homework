package com.home.work.whatisdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.home.work.whatisdocker"})
public class WhatisdockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatisdockerApplication.class, args);
	}
}
