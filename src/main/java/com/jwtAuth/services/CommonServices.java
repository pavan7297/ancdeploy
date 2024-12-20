package com.jwtAuth.services;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.Countrys;
import com.jwtAuth.model.DealerDetails;
import com.jwtAuth.model.DealerRegistration;
import com.jwtAuth.model.StatesModel;
import com.jwtAuth.model.querie;

public interface CommonServices {
	public List<Countrys> CountrysService(String strRequestID) throws Exception, SQLDataException;

	public List<StatesModel> stateByCountrieService(StatesModel states, String strRequestID)
			throws Exception, SQLDataException;

	public String saveDealerRegistration(DealerRegistration dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException;

	public String querieServices(querie querie, String strRequestID) throws Exception, SQLDataException;

	public List<querie> getallquerielistService(String strRequestID) throws Exception, SQLDataException;

	public String deletequerieService(querie querie, String strRequestID) throws Exception, SQLDataException;
}
