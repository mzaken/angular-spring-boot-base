package com.mzaken.springbootangularbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;

@SpringBootApplication
public class SpringBootAngularBaseApplication implements ErrorController {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularBaseApplication.class, args);
	}
	
	

}
