package com.webshop.simplewebapplication;

import com.webshop.simplewebapplication.Scheduler.SendMailScheduler;
import com.webshop.simplewebapplication.jdbcService.Example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableWebMvc
@EnableScheduling
public class SimpleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebApplication.class, args);
		System.out.println("http://127.0.0.1:8080/");
//		JBDC EXAMPLE
		Example ex = new Example();
		ex.getUser();
		ex.setUser();
	}
}
