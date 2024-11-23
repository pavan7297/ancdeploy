package com.jwtAuth.services;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.Countrys;
import com.jwtAuth.model.DealerRegistration;
import com.jwtAuth.model.StatesModel;

public interface CommonServices {
	public List<Countrys> CountrysService(String strRequestID)
			throws Exception, SQLDataException;
	
	public List<StatesModel> stateByCountrieService(StatesModel states ,String strRequestID)
			throws Exception, SQLDataException;

	public String saveDealerRegistration(DealerRegistration dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException;
}
