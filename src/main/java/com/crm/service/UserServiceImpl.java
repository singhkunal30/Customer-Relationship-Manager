package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crm.dto.UserDTO;
import com.crm.exception.CrmException;
import com.crm.mapper.DTOMapper;
import com.crm.model.SubAccount;
import com.crm.model.User;
import com.crm.repository.UserRepository;
import com.crm.utils.ErrorCode;
import com.crm.utils.ErrorMessage;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SubAccountService subAccountService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	DTOMapper mapper;
	
	@Autowired
	ErrorMessage errMsg;
	
	@Autowired
	ErrorCode errCode;

	@Override
	public UserDTO register(UserDTO userDTO) {
		try {
			userRepository.findByEmail(userDTO.getEmail()).ifPresent(user -> 
				new CrmException(errMsg.getUserAlreadyExist(), errCode.getUserAlreadyExist(), HttpStatus.BAD_REQUEST));
			userRepository.findByUsername(userDTO.getUsername()).ifPresent(user -> 
			new CrmException(errMsg.getUserAlreadyExist(), errCode.getUserAlreadyExist(), HttpStatus.BAD_REQUEST));
	
			userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			User user = mapper.toUser(userDTO);
			SubAccount subAccount = subAccountService.createSubAccount(userDTO.getUsername());
			user.setSubAccount(subAccount);
			User savedUser = userRepository.save(user);
			
			return mapper.toUserDTO(savedUser);
		}catch (CrmException ce) {
			throw ce;
		}
		catch (Exception e) {
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
		userDTO.setPassword(user.getPassword());
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
		return userRepository.findById(id).isEmpty();
	}
}
