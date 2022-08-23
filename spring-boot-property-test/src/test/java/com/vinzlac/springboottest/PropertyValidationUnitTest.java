package com.vinzlac.springboottest;

import com.vinzlac.springboottest.config.MailConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = MailConfig.class)
@TestPropertySource("classpath:property-validation-test.properties")
public class PropertyValidationUnitTest {
	@Autowired
	private MailConfig mailConfig;

	private static Validator propertyValidator;

	@BeforeAll
	public static void setup() {
		propertyValidator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	void whenBindingPropertiesToValidatedBeans_thenConstrainsAreChecked() {
		assertEquals(0, propertyValidator.validate(mailConfig.getPropertiesMap()).size());
		//assertEquals(0, propertyValidator.validate(mailConfig.getMail()).size());
	}
}
