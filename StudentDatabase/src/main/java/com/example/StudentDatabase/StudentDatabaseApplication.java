package com.example.StudentDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.StudentDatabase.config.jwtFilter;

@SpringBootApplication
@EnableConfigurationProperties

public class StudentDatabaseApplication {
	
	@SuppressWarnings("unchecked")
	@Bean
	public FilterRegistrationBean jwtFilter() 
	{
		final FilterRegistrationBean registrationBean= new FilterRegistrationBean();
		registrationBean.setFilter(new jwtFilter());
		registrationBean.addUrlPatterns("/api/*");
	      return registrationBean;
	                   
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentDatabaseApplication.class, args);
	}

}
