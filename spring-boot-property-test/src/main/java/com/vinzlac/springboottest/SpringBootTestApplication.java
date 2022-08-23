package com.vinzlac.springboottest;

import com.vinzlac.springboottest.config.MailConfig;
import com.vinzlac.springboottest.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestApplication {

	@Autowired
	ServerConfig serverConfig;

	@Autowired
	MailConfig mailConfig;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}

}
