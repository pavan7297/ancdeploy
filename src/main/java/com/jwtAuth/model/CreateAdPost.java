package com.jwtAuth.model;

import lombok.Data;

@Data
public class CreateAdPost {
	
	private String postdescription;
	private String postimg;
	private String postuser_id;
	private String poststate;
	private String postcity;
	private String postruntime;
	private String poststatus;
	
}
