package com.crm.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.crm.config.TwilioConfiguration;
import com.twilio.Twilio;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class TwilioInitializer {
	
	private final TwilioConfiguration twilioConfig;
	
	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfig) {
		this.twilioConfig = twilioConfig;
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
		log.info("Twilio account initialized with account sid:{}", twilioConfig.getAccountSid());
	}	

}
