package com.crm.service;

import com.crm.model.SubAccount;

public interface SubAccountService {
	
	SubAccount createSubAccount(String username);
	
	SubAccount getSubAccount(String accountSid);
}
