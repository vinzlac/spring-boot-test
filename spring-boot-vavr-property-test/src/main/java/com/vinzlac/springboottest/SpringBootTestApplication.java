package com.vinzlac.springboottest;

import com.vinzlac.springboottest.config.ServerConfig;
import com.vinzlac.springboottest.config.converter.SpaceConfigPropertyConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SpaceConfigPropertyConverter.class})
@Slf4j
public class SpringBootTestApplication implements CommandLineRunner {

  @Autowired ServerConfig serverConfig;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootTestApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("EXECUTING : command line runner");
    log.info("serverConfig = " + serverConfig);
  }
}
