package com.vinzlac.springboottest.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "server")
@Data
public class ServerConfig {
	private Address address;
	private Map<String, String> resourcesPath;
//	private io.vavr.collection.Map<String, Space> data;
	private Map<String, Space> data;

}
