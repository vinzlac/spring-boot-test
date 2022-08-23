package com.vinzlac.springboottest.config;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Mail {
	@NotBlank
	@Email
	private String address;

}
