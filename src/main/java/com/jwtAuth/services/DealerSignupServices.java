package com.jwtAuth.services;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.DealerAllDetails;
import com.jwtAuth.model.DealerDetails;
import com.jwtAuth.model.DealerLogin;
import com.jwtAuth.model.DealerSignup;

public interface DealerSignupServices {

	public String dealerdetailsatlogin(DealerDetails states, String strRequestID) throws Exception, SQLDataException;

	public List<DealerSignup> saveDealerRegistration(DealerSignup dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException;

	public List<DealerLogin> DealerLogin(DealerLogin dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException;

	public String updateDealerDetails(DealerAllDetails objdetails,String strRequestID)
			throws DataNotFoundException, SQLException;
	
	
	
	public List<DealerAllDetails> getDealersByIdService(DealerAllDetails dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException;
}
