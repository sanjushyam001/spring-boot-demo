package com.dailycodebuffer.springbootdemo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("SpringBootDemoApplication started");
		System.out.println("Changes done by sanjushyamgithub....");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
