package com.jwtAuth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Blogs {

	private String blogid;
	private String blogtitle;
	private String blogdescription;
	private String blogdateandtime;
	private String blogcategory;
	private String blogimgurl;

}
