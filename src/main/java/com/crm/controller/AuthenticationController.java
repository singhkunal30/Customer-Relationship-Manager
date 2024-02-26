package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.dto.UserDTO;
import com.crm.service.CustomUserDetailsService;
import com.crm.utils.JwtUtils;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/auth")
	public ResponseEntity<String> authenticate(@RequestBody UserDTO userDTO){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userDTO.getEmailId(), userDTO.getPassword()));
		UserDetails user = userDetailsService.loadUserByUsername(userDTO.getEmailId());
		if(user != null) {
			return new ResponseEntity<String>(jwtUtils.GenerateToken(user.getUsername()), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Some error has occured", HttpStatus.BAD_REQUEST);		
	}
}
