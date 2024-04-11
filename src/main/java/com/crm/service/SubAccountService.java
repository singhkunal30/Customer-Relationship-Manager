package com.crm.service;

import com.crm.model.SubAccount;

public interface SubAccountService {
	
	SubAccount createSubAccount(SubAccount subAccount);
	
	SubAccount getSubAccount(String accountSid);
}
