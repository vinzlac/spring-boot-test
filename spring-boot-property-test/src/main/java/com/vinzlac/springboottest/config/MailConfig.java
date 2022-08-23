package com.vinzlac.springboottest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "validate")
@Validated
@Getter
@Setter
public class MailConfig {
	@NotNull
	@NotEmpty
	private Map<String, @NotBlank String> propertiesMap;

	@Valid
	private Mail mail = new Mail();
}
