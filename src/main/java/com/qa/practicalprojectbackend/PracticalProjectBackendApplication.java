package com.qa.practicalprojectbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.practicalprojectbackend.rest.AnimalsController;

@SpringBootApplication
public class PracticalProjectBackendApplication {

	public static void main(String[] args) {
		 SpringApplication.run(PracticalProjectBackendApplication.class, args);
		
	}
}
