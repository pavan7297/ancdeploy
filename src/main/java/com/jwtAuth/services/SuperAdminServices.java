package com.jwtAuth.services;

import java.sql.SQLDataException;
import java.util.List;

import com.jwtAuth.model.Count;

public interface SuperAdminServices {

//	public List<Count> getDealersCountService(String strRequestID) throws Exception, SQLDataException;
	
	public String getDealersCountService(String strRequestID) throws Exception, SQLDataException;
	
	public String getUsersCountService(String strRequestID) throws Exception, SQLDataException;
	
	public String getTotalFunds(String strRequestID) throws Exception, SQLDataException;
	
	
	
	
}
