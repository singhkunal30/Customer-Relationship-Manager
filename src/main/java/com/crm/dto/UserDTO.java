package com.crm.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String roleName;
    private String accountSid;
}

