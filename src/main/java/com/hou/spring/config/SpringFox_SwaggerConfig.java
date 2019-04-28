package com.hou.spring.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFox_SwaggerConfig {
	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
        		/**
        		 * select creates a builder, which is used to define which controllers and which of their methods should 
        		 * be included in the generated documentation
        		 * */
                .select()
                /**
        		 * apis() defines the classes (controller and model classes) to be included. Here we are including all of them, 
        		 * but you can limit them by a base package, class annotations and more
        		 * */
                .apis(RequestHandlerSelectors.basePackage("com.hou.spring"))
                /**
        		 * paths() allow you to define which controller's methods should be included based on their path mappings.
        		 * We are now including all of them but you can limit it using regex and more
        		 * */
                .paths(PathSelectors.ant("/v2/**"))
                .build()
                .apiInfo(getApiInfo());
    }
	
	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "Documentation springFox",
	            "DESCIPRION",
	            "VERSION",
	            "TERMS OF SERVICE URL",
	            new Contact("NAME","URL","EMAIL"),
	            "LICENSE",
	            "LICENSE URL",
	            Collections.emptyList()
	    );
	}
}
