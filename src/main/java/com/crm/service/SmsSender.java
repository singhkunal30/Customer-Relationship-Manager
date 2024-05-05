package com.crm.service;

import java.util.HashSet;

import com.crm.utils.SmsRequest;

public interface SmsSender {
	
	void sendSms(SmsRequest smsRequest);

	void sendSmsToList(HashSet<SmsRequest> smsRequests);

}
