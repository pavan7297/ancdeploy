package com.jwtAuth.wrappers;

import java.io.Serializable;
import java.util.List;

import com.jwtAuth.model.Blogs;
import com.jwtAuth.response.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class BlogWrappers extends Response implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4759720867312847702L;
	
	public String createblog;
	public List<Blogs> blogsList;
	public String blogupdate;


}
