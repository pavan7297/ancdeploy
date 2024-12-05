package com.jwtAuth.services;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.Blogs;
import com.jwtAuth.model.DealerDetails;
import com.jwtAuth.model.DealerSignup;

public interface BlogServices {

	public String createBlogs(Blogs blogs, String strRequestID) throws Exception, SQLDataException;

	public List<Blogs> getAllBlogs(String strRequestID) throws DataNotFoundException, SQLException;
	
	public List<Blogs> getBlogsbyId(Blogs blogs , String strRequestID) throws DataNotFoundException, SQLException;

	public String updateBlogs(Blogs blogs, String strRequestID) throws Exception, SQLDataException;
	
	public String deleteBlogs(Blogs blogs, String strRequestID) throws Exception, SQLDataException;
}
