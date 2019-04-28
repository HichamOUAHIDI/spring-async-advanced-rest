package com.hou.spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringAdvancedRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdvancedRestApplication.class, args);
	}
	/**
	 * define the ModelMapper bean
	 * */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
