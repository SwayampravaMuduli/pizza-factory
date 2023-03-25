package com.amazin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PizzaFactoryServiceApplication {
	public static ApplicationContext ctx;
	public static void main(String[] args) {
		ctx = new SpringApplicationBuilder(PizzaFactoryServiceApplication.class).build().run(args);
		//SpringApplication.run(PizzaFactoryServiceApplication.class, args);
	}

}
