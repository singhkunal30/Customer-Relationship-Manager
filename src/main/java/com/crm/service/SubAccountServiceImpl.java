package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.crm.exception.CrmException;
import com.crm.model.SubAccount;
import com.crm.repository.SubAccountRepository;
import com.crm.twilio.config.TwilioConfiguration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.Account;

public class SubAccountServiceImpl implements SubAccountService{
	
	@Autowired
	SubAccountRepository subAccountRepository;
	
	@Autowired
	TwilioConfiguration twilioConfig;

	@Override
	public SubAccount createSubAccount(String username) {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
		Account account = Account.creator().setFriendlyName(username).create();
		SubAccount subAccount = new SubAccount(account.getSid(), account.getAuthToken());
		return subAccountRepository.save(subAccount);
	}

	@Override
	public SubAccount getSubAccount(String accountSid) {
		SubAccount subAccount = subAccountRepository.findByAccountSid(accountSid)
				.orElseThrow(() -> new CrmException("not found", (long) 11, HttpStatus.NOT_FOUND));
		return subAccount;
	}

}
