package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.twilio.config.TwilioConfiguration;
import com.crm.utils.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TwilioSmsSender implements SmsSender{
	
	@Autowired
	TwilioConfiguration twilioConfig;
	
	@Override
	public void sendSms(SmsRequest smsRequest) {
		PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
		PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
		String message = smsRequest.getMessage();
		MessageCreator creator = Message.creator(to, from, message);
		creator.create();
		log.info("Message sent");
	}

}
