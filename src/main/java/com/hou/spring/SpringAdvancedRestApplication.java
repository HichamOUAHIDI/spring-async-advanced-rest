package com.hou.spring;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
