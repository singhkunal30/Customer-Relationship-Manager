package com.crm.service;

import com.crm.utils.SmsRequest;

public interface SmsSender {
	
	void sendSms(SmsRequest smsRequest);

}
