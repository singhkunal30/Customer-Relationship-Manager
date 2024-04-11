package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.crm.exception.CrmException;
import com.crm.model.SubAccount;
import com.crm.repository.SubAccountRepository;

public class SubAccountServiceImpl implements SubAccountService{
	
	@Autowired
	SubAccountRepository subAccountRepository;

	@Override
	public SubAccount createSubAccount(SubAccount subAccount) {
		return subAccountRepository.save(subAccount); 
	}

	@Override
	public SubAccount getSubAccount(String accountSid) {
		SubAccount subAccount = subAccountRepository.findByAccountSid(accountSid)
				.orElseThrow(() -> new CrmException("not found", (long) 11, HttpStatus.NOT_FOUND));
		return subAccount;
	}

}
