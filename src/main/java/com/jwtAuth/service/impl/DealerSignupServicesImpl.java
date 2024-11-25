package com.jwtAuth.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jwtAuth.dao.AppData;
import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.DealerSignup;
import com.jwtAuth.services.DealerSignupServices;


import lombok.extern.slf4j.Slf4j;

@Service("DealerRegsserviceimpl")
@Slf4j
public class DealerSignupServicesImpl implements DealerSignupServices{
	
	
	@Autowired
	@Qualifier("objCommonDaoImpls")
	AppData objAppdata;

	@Value("${spring.datasource.url}")
	private String strJdbcUrl;

	@Value("${spring.datasource.username}")
	private String strDBUSERNAME;

	@Value("${spring.datasource.password}")
	private String strDBPWD;

//	@Override
//	public List<DealerSignup> dSignupService(DealerSignup states, String strRequestID)
//			throws Exception, SQLDataException {
//		PreparedStatement cs = null;
//		
//	}

	@Override
	public String saveDealerRegistration(DealerSignup dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call insert_customer_order(?,?,?,?)}");
			cs.setString(1, dataServiceDTO.getUsername());
			cs.setString(2, dataServiceDTO.getEmail());
			cs.setString(3, dataServiceDTO.getPassword());
			cs.setString(4, dataServiceDTO.getRole());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.getSingleData(cs.toString());
		return output;

	}

	
	
}
