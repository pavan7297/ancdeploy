package com.jwtAuth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Countrys {

	private String country_id;
	
	private String country_name; 
	
	private String country_code;
}
