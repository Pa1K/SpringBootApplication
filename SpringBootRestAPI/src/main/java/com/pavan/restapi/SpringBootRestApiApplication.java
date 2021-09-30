package com.pavan.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.pavan.restapi.model.Employee;

@SpringBootApplication
public class SpringBootRestApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBootRestApiApplication.class, args); 
		
		
		Employee user = ctxt.getBean(Employee.class);
		user.display();
		
		
		/*
		 * User user1 = ctxt.getBean(User.class); user1.display();
		 */
		
		
	}

}

/**
the following error we get class is not annotated with @Component or similar annotations
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.pavan.restapi.model.User' available
*/