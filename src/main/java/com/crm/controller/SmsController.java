package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.model.SmsRequest;
import com.crm.service.TwilioSmsSender;
import com.crm.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sms")
@CrossOrigin("*")
public class SmsController {
	
	@Autowired
	TwilioSmsSender twilioSmsSender;
	
	@PostMapping("/send")
	public void sendSms(HttpServletRequest request){
		SmsRequest smsRequest = JsonUtils.bindRequestToObject(request, new TypeReference<SmsRequest>() {});
		twilioSmsSender.sendSms(smsRequest);	
	}
}
