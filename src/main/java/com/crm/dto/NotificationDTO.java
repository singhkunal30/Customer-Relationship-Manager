package com.crm.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
	
    private Long notificationId;
    private String message;
    private Date createdDateTime;
    private Long userId;
    private String username;
    
}