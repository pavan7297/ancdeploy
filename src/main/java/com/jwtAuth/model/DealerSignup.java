package com.jwtAuth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class DealerSignup {

	private String id;
	private String username;
	private String email;
	private String password;
	private String role;
	private String message;
}
