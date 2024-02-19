package com.crm.utils;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
@PropertySource("classpath:error.properties")
public class ErrorCode {
	
	public final long customerNotFound;
	public final long invalidRequest;
	
	public ErrorCode(Environment env) {
		this.customerNotFound=Long.valueOf(env.getProperty("error.code.customer.not.found"));
		this.invalidRequest=Long.valueOf(env.getProperty("error.code.invalid.request"));
	}

}
