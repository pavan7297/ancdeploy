package com.jwtAuth.model;

import lombok.Data;

@Data
public class AddTeamMembers {

	private String img;
	
	private String first_name;
	
    private String last_name ;
    
    private String email ;
    
    private String phone_number ;
    
    private String positions ;
    
    private String gender;
}
