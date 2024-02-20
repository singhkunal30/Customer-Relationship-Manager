package com.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String emailId;

}
