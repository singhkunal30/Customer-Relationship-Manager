package com.crm.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler(CommonException.class)
	public ResponseEntity<Object> handleCommonException(CommonException ce, WebRequest request){
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", ce.getTimestamp());
		body.put("message", ce.getErrMsg());
		body.put("error code", ce.getErrCode());
		return new ResponseEntity<>(body, ce.getHttpStatus());
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<Object> handleCustomerException(CustomerException ce, WebRequest request){
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", ce.getTimestamp());
		body.put("message", ce.getErrMsg());
		body.put("error code", ce.getErrCode());
		return new ResponseEntity<>(body, ce.getHttpStatus());
	}
}
