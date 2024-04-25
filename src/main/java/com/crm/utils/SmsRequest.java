package com.crm.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SmsRequest {
	
	@Nonnull
    private final String phoneNumber;

    @Nonnull
    private final String message;

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

}
