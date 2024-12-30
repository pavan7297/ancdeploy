package com.jwtAuth.dao;

import java.util.List;

import com.jwtAuth.exceptions.DataNotFoundException;


public interface AppData {
	public List<?> getData(String strQuery);

	public String saveData(String strQuery);

	public String getSingleData(String strQuery) throws DataNotFoundException;
	
	public String executeStoredProcedure(String strProcedureQuery, Object[] params);

}

