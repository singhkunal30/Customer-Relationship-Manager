package com.crm.utils;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
@PropertySource("classpath:error.properties")
public class ErrorCode {
	
	public final long contactNotFound;
	public final long userNotFound;
	public final long invalidRequest;
	public final long invalidJwtToken;
	public final long userAlreadyExist;
	
	public ErrorCode(Environment env) {
		this.contactNotFound=Long.valueOf(env.getProperty("error.code.contact.not.found"));
		this.invalidRequest=Long.valueOf(env.getProperty("error.code.invalid.request"));
		this.userNotFound=Long.valueOf(env.getProperty("error.code.user.not.found"));
		this.invalidJwtToken=Long.valueOf(env.getProperty("error.code.jwt.invalid.token"));
		this.userAlreadyExist=Long.valueOf(env.getProperty("error.code.user.already.exist"));
	}

}
