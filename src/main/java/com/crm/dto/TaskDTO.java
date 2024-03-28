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
public class TaskDTO {
	
    private Long taskId;
    private String title;
    private String description;
    private Date deadline;
    private Long assignedToUserId;
    private String assignedToUsername;
    private Long assignedByUserId;
    private String assignedByUsername;

}
