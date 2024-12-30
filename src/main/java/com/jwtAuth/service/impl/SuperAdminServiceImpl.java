package com.jwtAuth.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jwtAuth.dao.AppData;
import com.jwtAuth.model.Count;
import com.jwtAuth.model.Countrys;
import com.jwtAuth.services.SuperAdminServices;
import com.jwtAuth.utils.CommonConstants;

import lombok.extern.slf4j.Slf4j;

@Service("superadminServicesimpl")
@Slf4j
public class SuperAdminServiceImpl implements SuperAdminServices{
	
	
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
	public String getDealersCountService(String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_dealer_count()}");
			
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
	public String getUsersCountService(String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_users_count()}");
			
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
	public String getTotalFunds(String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_total_funds()}");
			
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
	public String userPercentageServices(String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_user_percentage_change()}");
			
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
	public String dealerPercentageServices(String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_dealer_percentage_change()}");
			
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
	public String totalfundsPercentageServices(String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_total_funds_percentage_change()}");
			
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
