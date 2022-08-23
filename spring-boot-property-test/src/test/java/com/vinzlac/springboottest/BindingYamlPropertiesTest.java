package com.vinzlac.springboottest;

import com.vinzlac.springboottest.config.ServerConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = ServerConfig.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
public class BindingYamlPropertiesTest {

	@Autowired
	private ServerConfig serverConfig;

	@Test
	void givenUserDefinedPOJO_whenBindingPropertiesFile_thenAllFieldsAreSet() {
		assertEquals("192.168.0.1", serverConfig.getAddress().getIp());

		Map<String, String> expectedResourcesPath = new HashMap<>();
		expectedResourcesPath.put("imgs", "/root/imgs");
		assertEquals(expectedResourcesPath, serverConfig.getResourcesPath());
	}

	@Test
	void test() {

	}
}