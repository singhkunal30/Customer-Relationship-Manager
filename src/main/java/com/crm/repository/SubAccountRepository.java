package com.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.model.SubAccount;

public interface SubAccountRepository extends JpaRepository<SubAccount, Long>{
	
	Optional<SubAccount> findByAccountSid(String accountSid);
}
