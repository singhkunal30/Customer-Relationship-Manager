package com.crm.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.crm.exception.CrmException;
import com.crm.model.User;
import com.crm.repository.UserRepository;
import com.crm.utils.ErrorCode;
import com.crm.utils.ErrorMessage;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ErrorMessage errMsg;
	
	@Autowired
	private ErrorCode errCode;
	
	@Override
	public UserDetails loadUserByUsername(String input) {
		User user = userRepository.findByEmailOrUsername(input, input).orElseThrow(() -> 
		new CrmException(errMsg.getUserNotFound(), errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), 
				user.getPassword(), Collections.emptyList());
	}
}
