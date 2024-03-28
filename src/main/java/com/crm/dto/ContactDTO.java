package com.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactDTO {
    private Long contactId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String company;
    private Long userId;
    private String username;

}