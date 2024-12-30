package com.jwtAuth.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jwtAuth.dao.AppData;
import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.DealerAllDetails;
import com.jwtAuth.model.DealerDetails;
import com.jwtAuth.model.DealerLogin;
import com.jwtAuth.model.DealerSignup;
import com.jwtAuth.services.DealerSignupServices;
import com.jwtAuth.utils.CommonConstants;

import lombok.extern.slf4j.Slf4j;

@Service("DealerRegsserviceimpl")
@Slf4j
public class DealerSignupServicesImpl implements DealerSignupServices {

	@Autowired
	@Qualifier("objCommonDaoImpls")
	AppData objAppdata;

	@Value("${spring.datasource.url}")
	private String strJdbcUrl;

	@Value("${spring.datasource.username}")
	private String strDBUSERNAME;

	@Value("${spring.datasource.password}")
	private String strDBPWD;

	@Override
	public List<DealerSignup> saveDealerRegistration(DealerSignup dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call user_signup(?,?,?,?)}");
			cs.setString(1, dataServiceDTO.getUsername());
			cs.setString(2, dataServiceDTO.getEmail());
			cs.setString(3, dataServiceDTO.getPassword());
			cs.setString(4, dataServiceDTO.getRole());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<DealerSignup> signupList = data.stream().map((Object[] objects) -> {
			DealerSignup sign = new DealerSignup();

			if (objects[0] != null) {
				sign.setUserid(objects[0].toString());
			} else {
				sign.setUserid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				sign.setMessage(objects[1].toString());
			} else {
				sign.setMessage(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return sign;
		}).collect(Collectors.toList());

		return signupList;

	}

	@Override
	public List<DealerLogin> DealerLogin(DealerLogin dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call user_login(?,?)}");
			cs.setString(1, dataServiceDTO.getEmail());
			cs.setString(2, dataServiceDTO.getPassword());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<DealerLogin> LoginList = data.stream().map((Object[] objects) -> {
			DealerLogin log = new DealerLogin();

			if (objects[0] != null) {
				log.setId(objects[0].toString());
			} else {
				log.setId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				log.setEmail(objects[1].toString());
			} else {
				log.setEmail(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				log.setRole(objects[2].toString());
			} else {
				log.setRole(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				log.setMessage(objects[3].toString());
			} else {
				log.setMessage(CommonConstants.DATA_NOT_AVIALABLE);
			}

			return log;
		}).collect(Collectors.toList());

		return LoginList;

	}

	@Override
	public String dealerdetailsatlogin(DealerDetails states, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call insert_dealer_details(?,?,?)}");
			cs.setString(1, states.getId());
			cs.setString(2, states.getUsername());
			cs.setString(3, states.getEmail());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		return objAppdata.getSingleData(cs.toString());
	}
	
	
	@Override
	public String updateDealerDetails(DealerAllDetails objdetails, String strRequestID) throws SQLException, DataNotFoundException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call update_dealer_details(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, objdetails.getId());
			cs.setString(2, objdetails.getFirst_name());
			cs.setString(3, objdetails.getLast_name());
			cs.setString(4, objdetails.getCompany_name());
			cs.setString(5, objdetails.getCountry());
			cs.setString(6, objdetails.getAddress1());
			cs.setString(7, objdetails.getAddress2());
			cs.setString(8, objdetails.getCity());
			cs.setString(9, objdetails.getState());
			cs.setString(10, objdetails.getZip_code());
			cs.setString(11, objdetails.getPhone());
			cs.setString(12, objdetails.getShip_to_diffrent_address());
			
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		return objAppdata.getSingleData(cs.toString());
	}

	@Override
	public List<DealerAllDetails> getDealersByIdService(DealerAllDetails dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_dealer_details_by_id(?)}");
			cs.setString(1, dataServiceDTO.getId());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<DealerAllDetails> LoginList = data.stream().map((Object[] objects) -> {
			DealerAllDetails log = new DealerAllDetails();

			if (objects[0] != null) {
				log.setId(objects[0].toString());
			} else {
				log.setId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				log.setFirst_name(objects[1].toString());
			} else {
				log.setFirst_name(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				log.setLast_name(objects[2].toString());
			} else {
				log.setLast_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				log.setCompany_name(objects[3].toString());
			} else {
				log.setCompany_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				log.setCountry(objects[4].toString());
			} else {
				log.setCountry(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[5] != null) {
				log.setAddress1(objects[5].toString());
			} else {
				log.setAddress1(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[6] != null) {
				log.setAddress2(objects[6].toString());
			} else {
				log.setAddress2(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[7]!= null) {
				log.setCity(objects[7].toString());
			} else {
				log.setCity(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[8] != null) {
				log.setState(objects[8].toString());
			} else {
				log.setState(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[9] != null) {
				log.setZip_code(objects[9].toString());
			} else {
				log.setZip_code(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[10] != null) {
				log.setPhone(objects[10].toString());
			} else {
				log.setPhone(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[11] != null) {
				log.setShip_to_diffrent_address(objects[11].toString());
			} else {
				log.setShip_to_diffrent_address(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return log;
		}).collect(Collectors.toList());

		return LoginList;


	}

}
