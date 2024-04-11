package com.crm.service;

import com.crm.model.SmsRequest;

public interface SmsSender {
	
	void sendSms(SmsRequest smsRequest);

}
