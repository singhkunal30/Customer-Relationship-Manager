package com.crm.utils;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
@PropertySource("classpath:error.properties")
public class ErrorMessage {
	
	public final String customerNotFound;
	public final String userNotFound;
	public final String invalidRequest;
	
	public ErrorMessage(Environment env) {
		this.customerNotFound=env.getProperty("error.message.customer.not.found");
		this.invalidRequest=env.getProperty("error.message.invalid.request");
		this.userNotFound=env.getProperty("error.message.user.not.found");
	}

}
