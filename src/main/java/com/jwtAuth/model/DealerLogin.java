package com.jwtAuth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class DealerLogin {
	
	private String id;
	
	private String email;
	
	private String password;
	
	private String role;
	
	private String message;

}
