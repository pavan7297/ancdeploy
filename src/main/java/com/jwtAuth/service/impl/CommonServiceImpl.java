package com.jwtAuth.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import com.jwtAuth.model.Countrys;
import com.jwtAuth.model.DealerRegistration;
import com.jwtAuth.model.StatesModel;
import com.jwtAuth.model.querie;
import com.jwtAuth.services.CommonServices;
import com.jwtAuth.utils.CommonConstants;

import lombok.extern.slf4j.Slf4j;

@Service("commonserviceimpl")
@Slf4j
public class CommonServiceImpl implements CommonServices {

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
	public List<Countrys> CountrysService(String strRequestID) throws Exception, SQLDataException {
//		List<Countrys> objCheckEmail = null;
		PreparedStatement cs = null;
		Connection connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
		try {
//			connection = 
			System.err.println("check the connections :::::::" + connection);
			cs = connection.prepareCall("{call get_countries()}");
			System.err.println("check the queary :::::::" + cs);
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {
			connection.close();
		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<Countrys> countriesList = data.stream().map((Object[] objects) -> {
			Countrys countrie = new Countrys();

			if (objects[0] != null) {
				countrie.setCountry_id(objects[0].toString());
			} else {
				countrie.setCountry_id(CommonConstants.DATA_NOT_AVIALABLE);
				
			}
			if (objects[1] != null) {
				countrie.setCountry_name(objects[1].toString());
			} else {
				countrie.setCountry_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				countrie.setCountry_code(objects[2].toString());
			} else {
				countrie.setCountry_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return countrie;
		}).collect(Collectors.toList());

		return countriesList;

	}

	@Override
	public List<StatesModel> stateByCountrieService(StatesModel states, String strRequestID)
			throws Exception, SQLDataException {
		PreparedStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_states_by_country(?)}");
			cs.setString(1, states.getCountry_code());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// Log the error and proceed
					System.err.println("Failed to close connection: " + e.getMessage());
				}
			}
		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<StatesModel> statesList = data.stream().map((Object[] objects) -> {
			StatesModel state = new StatesModel();

			if (objects[0] != null) {
				state.setStates_id(objects[0].toString());
			} else {
				state.setStates_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				state.setStates_state_name(objects[1].toString());
			} else {
				state.setStates_state_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return state;
		}).collect(Collectors.toList());

		return statesList;

	}

	@Override
	public String saveDealerRegistration(DealerRegistration dataServiceDTO, String strRequestID)
			throws DataNotFoundException, SQLException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call insert_customer_order(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, dataServiceDTO.getFirst_name());
			cs.setString(2, dataServiceDTO.getLast_name());
			cs.setString(3, dataServiceDTO.getCompany_name());
			cs.setString(4, dataServiceDTO.getCountry());
			cs.setString(5, dataServiceDTO.getAddress1());
			cs.setString(6, dataServiceDTO.getAddress2());
			cs.setString(7, dataServiceDTO.getCity());
			cs.setString(8, dataServiceDTO.getState());
			cs.setString(9, dataServiceDTO.getZipcode());
			cs.setString(10, dataServiceDTO.getPhone());
			cs.setString(11, dataServiceDTO.getEmail());
			cs.setString(12, dataServiceDTO.getShip_to_different_addres());
			cs.setString(13, dataServiceDTO.getOrder_notes());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.getSingleData(cs.toString());
		return output;
	}

	@Override
	public String querieServices(querie querie, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call add_query(?,?,?,?)}");
			cs.setString(1, querie.getName());
			cs.setString(2, querie.getEmail());
			cs.setString(3, querie.getSubject());
			cs.setString(4, querie.getMessage());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		return objAppdata.saveData(cs.toString());
	}

	@Override
	public List<querie> getallquerielistService(String strRequestID) throws Exception, SQLDataException {
		List<querie> objChecklist = null;
		PreparedStatement cs = null;
		Connection connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
		try {
//			connection = 
			System.err.println("check the connections :::::::" + connection);
			cs = connection.prepareCall("{call get_all_queries()}");
			System.err.println("check the queary :::::::" + cs);
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {
			connection.close();
		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<querie> querieList = data.stream().map((Object[] objects) -> {
			querie querie = new querie();

			if (objects[0] != null) {
				querie.setId(Integer.parseInt(objects[0].toString()));
			} else {
				querie.setId(CommonConstants.DATA_NOT_AVIALABLE_INT);
			}
			if (objects[1] != null) {
				querie.setName(objects[1].toString());
			} else {
				querie.setName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				querie.setEmail(objects[2].toString());
			} else {
				querie.setEmail(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				querie.setSubject(objects[3].toString());
			} else {
				querie.setSubject(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				querie.setMessage(objects[4].toString());
			} else {
				querie.setMessage(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				querie.setTimeStamp(objects[5].toString());
			} else {
				querie.setTimeStamp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return querie;
		}).collect(Collectors.toList());

		return querieList;

	}

	@Override
	public String deletequerieService(querie querie, String strRequestID) throws Exception, SQLDataException {
		PreparedStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call delete_query(?)}");
			cs.setInt(1, querie.getId());
			System.out.println(cs.toString());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		return objAppdata.saveData(cs.toString());
	}

}
