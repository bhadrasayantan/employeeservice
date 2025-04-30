package com.example.employeeservice.configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSConfiguration implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET","POST","PUT","DELETE")
			.allowedHeaders("Access-Control-Allow-Origin",
		            "*",
		            "Access-Control-Allow-Methods",
		            "POST, GET, OPTIONS, PUT, DELETE",
		            "Access-Control-Allow-Headers",
		            "Origin, X-Requested-With, Content-Type, Accept");
		
	}

}
