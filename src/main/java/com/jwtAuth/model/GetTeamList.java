package com.jwtAuth.model;

import lombok.Data;

@Data
public class GetTeamList {
	
	private String id;

	private String img;

	private String first_name;

	private String last_name;

	private String email;

	private String phone_number;

	private String positions;

	private String gender;
}
