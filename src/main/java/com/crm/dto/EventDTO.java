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
public class EventDTO {
	
    private Long eventId;
    private String title;
    private String description;
    private Date startDateTime;
    private Date endDateTime;
    private String location;
    private Long userId;
    private String username;
    
}