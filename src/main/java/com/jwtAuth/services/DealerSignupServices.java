package com.jwtAuth.services;

import java.sql.SQLException;

import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.DealerSignup;

public interface DealerSignupServices {
	
//	public List<DealerSignup> dSignupService(DealerSignup states ,String strRequestID)
//			throws Exception, SQLDataException;

	public String saveDealerRegistration(DealerSignup dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException;
}
