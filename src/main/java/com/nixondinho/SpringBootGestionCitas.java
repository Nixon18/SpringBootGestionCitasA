package com.nixondinho;

import org.apache.commons.logging.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class SpringBootGestionCitas {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGestionCitas.class, args);
		org.jboss.logging.Logger logo = LoggerFactory.logger(SpringBootGestionCitas.class);
		

	}
	

}
