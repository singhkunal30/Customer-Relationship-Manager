package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crm.config.TwilioConfiguration;
import com.crm.dto.UserDTO;
import com.crm.exception.CrmException;
import com.crm.mapper.DTOMapper;
import com.crm.model.SubAccount;
import com.crm.model.User;
import com.crm.repository.UserRepository;
import com.crm.utils.ErrorCode;
import com.crm.utils.ErrorMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.Account;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TwilioConfiguration twilioConfig;
	
	@Autowired
	DTOMapper mapper;
	
	@Autowired
	ErrorMessage errMsg;
	
	@Autowired
	ErrorCode errCode;

	@Override
	public UserDTO register(UserDTO userDTO) {
		try {
			Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
			Account subAccount = Account.creator().setFriendlyName(userDTO.getUsername()).create();
			User user = mapper.toUser(userDTO);
			user.setSubAccount(new SubAccount(subAccount.getSid(), subAccount.getAuthToken()));
			User savedUser = userRepository.save(user);
			return mapper.toUserDTO(savedUser);
		}catch (Exception e) {
			throw new CrmException(e.getMessage(), errCode.getInvalidRequest() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public UserDTO getUser(long id) {
		User user = userRepository.findById(id).orElseThrow(
				()-> new CrmException(errMsg.getUserNotFound(), errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		return mapper.toUserDTO(user);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		User user = userRepository.findById(userDTO.getUserId())
				.orElseThrow(() -> new CrmException(errMsg.getUserNotFound() + " " +userDTO.getUserId(), 
						errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		User updatedUser = mapper.toUser(userDTO);
		updatedUser.setUserId(userDTO.getUserId());
		userRepository.save(updatedUser);
		return mapper.toUserDTO(updatedUser);
	}

	@Override
	public boolean removeUser(long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new CrmException(errMsg.getUserNotFound()+ " " +id, 
						errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		userRepository.delete(user);
		return true;
	}
}
