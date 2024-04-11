package com.crm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@ConfigurationProperties("twilio")
@Getter
@Setter
@NoArgsConstructor
public class TwilioConfiguration {
	
	private String accountSid;
	private String authToken;
	private String trialNumber;
}
