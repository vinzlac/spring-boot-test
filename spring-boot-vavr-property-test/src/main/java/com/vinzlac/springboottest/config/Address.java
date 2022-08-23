package com.vinzlac.springboottest.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@Value
@NonFinal
public class Address {
	private String ip;
}
