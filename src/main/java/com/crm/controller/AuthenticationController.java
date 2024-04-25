package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.security.JwtRequest;
import com.crm.security.JwtToken;
import com.crm.security.utils.CustomUserDetailsService;
import com.crm.utils.JsonUtils;
import com.crm.utils.JwtUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin("*")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/auth")
	public ResponseEntity<JwtToken> authenticate(HttpServletRequest request){
		JwtRequest jwtRequest = JsonUtils.bindRequestToObject(request, new TypeReference<JwtRequest>() {});
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		UserDetails user = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		JwtToken token = new JwtToken(jwtUtils.GenerateToken(user.getUsername()));
		return new ResponseEntity<JwtToken>(token, HttpStatus.OK);	
	}
	
	@PostMapping("/validate-token")
	public ResponseEntity<Boolean> validateToken(@RequestBody JwtToken jwtToken){
		String token = jwtToken.getToken();
		String userName = jwtUtils.extractUsername(token);
		UserDetails user = userDetailsService.loadUserByUsername(userName);
		return new ResponseEntity<Boolean>(jwtUtils.validateToken(token, user), HttpStatus.OK);
	}
	
}
