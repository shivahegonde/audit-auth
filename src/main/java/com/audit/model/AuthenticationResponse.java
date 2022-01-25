package com.audit.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthenticationResponse {
	private String name;
	private String projectName;
	private String appOwnerName;
	private boolean isValid;
}
