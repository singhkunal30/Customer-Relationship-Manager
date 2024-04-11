package com.crm.service;

import com.crm.dto.UserDTO;

public interface UserService {
	
	UserDTO register(UserDTO userDTO);
	
	UserDTO getUser(long id);
	
	UserDTO updateUser(UserDTO userDTO);
	
	boolean removeUser(long id);
}
