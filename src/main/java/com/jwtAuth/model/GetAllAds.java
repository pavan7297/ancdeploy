package com.jwtAuth.model;

import lombok.Data;

@Data
public class GetAllAds {
	
	private String postid;
	private String postdescription;
	private String postimg;
	private String dealername;
	private String dealernumber;
	private String state;
	private String city;
	private String runtime;
	private String poststatus;

}
