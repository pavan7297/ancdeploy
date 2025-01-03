package com.jwtAuth.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jwtAuth.dao.AppData;
import com.jwtAuth.model.AddTeamMembers;
import com.jwtAuth.model.DeleteTeamMember;
import com.jwtAuth.model.GetTeamList;
import com.jwtAuth.model.UpdateTeamMember;
import com.jwtAuth.model.getAllDealers;
import com.jwtAuth.services.SuperAdminServices;
import com.jwtAuth.utils.CommonConstants;

import lombok.extern.slf4j.Slf4j;

@Service("superadminServicesimpl")
@Slf4j
public class SuperAdminServiceImpl implements SuperAdminServices {

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

	@Override
	public String addTeam(AddTeamMembers teamMembers, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		System.err.println(":::::::::::::::data::::::::::::::::"+teamMembers);
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call add_team_member(?,?,?,?,?,?,?)}");
			cs.setString(1, teamMembers.getImg());
			cs.setString(2, teamMembers.getFirst_name());
			cs.setString(3, teamMembers.getLast_name());
			cs.setString(4, teamMembers.getEmail());
			cs.setString(5, teamMembers.getPhone_number());
			cs.setString(6, teamMembers.getPositions());
			cs.setString(7, teamMembers.getGender());

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.saveData(cs.toString());
		return output;

	}
	
	
	@Override
	public List<GetTeamList> getTeamServices(String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_all_team_members()}");

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<GetTeamList> LoginList = data.stream().map((Object[] objects) -> {
			GetTeamList log = new GetTeamList();

			if (objects[0] != null) {
				log.setId(objects[0].toString());
			} else {
				log.setId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				log.setImg(objects[1].toString());
			} else {
				log.setImg(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				log.setFirst_name(objects[2].toString());
			} else {
				log.setFirst_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				log.setLast_name(objects[3].toString());
			} else {
				log.setLast_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				log.setEmail(objects[4].toString());
			} else {
				log.setEmail(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[5] != null) {
				log.setPhone_number(objects[5].toString());
			} else {
				log.setPhone_number(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[6] != null) {
				log.setPositions(objects[6].toString());
			} else {
				log.setPositions(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[7]!= null) {
				log.setGender(objects[7].toString());
			} else {
				log.setGender(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return log;
		}).collect(Collectors.toList());

		return LoginList;


	}

	@Override
	public List<GetTeamList> getTeamByIdServices(GetTeamList getTeamList, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_team_member_by_id(?)}");
			cs.setString(1, getTeamList.getId());

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<GetTeamList> LoginList = data.stream().map((Object[] objects) -> {
			GetTeamList log = new GetTeamList();

			if (objects[0] != null) {
				log.setId(objects[0].toString());
			} else {
				log.setId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				log.setImg(objects[1].toString());
			} else {
				log.setImg(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				log.setFirst_name(objects[2].toString());
			} else {
				log.setFirst_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				log.setLast_name(objects[3].toString());
			} else {
				log.setLast_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				log.setEmail(objects[4].toString());
			} else {
				log.setEmail(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[5] != null) {
				log.setPhone_number(objects[5].toString());
			} else {
				log.setPhone_number(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[6] != null) {
				log.setPositions(objects[6].toString());
			} else {
				log.setPositions(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[7]!= null) {
				log.setGender(objects[7].toString());
			} else {
				log.setGender(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return log;
		}).collect(Collectors.toList());

		return LoginList;

	}

	@Override
	public String updateTeamMembersServices(UpdateTeamMember team, String strRequestID)
			throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		System.err.println(":::::::::::::::data::::::::::::::::"+team);
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call update_team_member(?,?,?,?,?,?,?,?)}");
			cs.setString(1, team.getMember_id());
			cs.setString(2, team.getImg());
			cs.setString(3, team.getFirst_name());
			cs.setString(4, team.getLast_name());
			cs.setString(5, team.getEmail());
			cs.setString(6, team.getPhone_number());
			cs.setString(7, team.getPositions());
			cs.setString(8, team.getGender());

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.saveData(cs.toString());
		return output;
	}

	@Override
	public String deleteTeamMembersServices(DeleteTeamMember team, String strRequestID)
			throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		System.err.println(":::::::::::::::data::::::::::::::::"+team);
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call delete_team_member(?)}");
			cs.setString(1, team.getDelete_id());

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.saveData(cs.toString());
		return output;
	}

	@Override
	public List<getAllDealers> getAllDealersServices(String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_all_dealers()}");

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<getAllDealers> dealerlist = data.stream().map((Object[] objects) -> {
			getAllDealers log = new getAllDealers();

			if (objects[0] != null) {
				log.setDealer_id(objects[0].toString());
			} else {
				log.setDealer_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				log.setUser_id(objects[1].toString());
			} else {
				log.setUser_id(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				log.setFirst_name(objects[2].toString());
			} else {
				log.setFirst_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				log.setLast_name(objects[3].toString());
			} else {
				log.setLast_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				log.setImage_url(objects[4].toString());
			} else {
				log.setImage_url(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[5] != null) {
				log.setCompany_name(objects[5].toString());
			} else {
				log.setCompany_name(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[6] != null) {
				log.setCountry(objects[6].toString());
			} else {
				log.setCountry(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[7]!= null) {
				log.setAddress1(objects[7].toString());
			} else {
				log.setAddress1(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[8]!= null) {
				log.setAddress2(objects[8].toString());
			} else {
				log.setAddress2(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[9]!= null) {
				log.setCity(objects[9].toString());
			} else {
				log.setCity(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[10]!= null) {
				log.setState(objects[10].toString());
			} else {
				log.setState(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[11]!= null) {
				log.setZipcode(objects[11].toString());
			} else {
				log.setZipcode(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[12]!= null) {
				log.setPhone(objects[12].toString());
			} else {
				log.setPhone(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[13]!= null) {
				log.setEmail(objects[13].toString());
			} else {
				log.setEmail(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[14]!= null) {
				log.setUsername(objects[14].toString());
			} else {
				log.setUsername(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[15]!= null) {
				log.setTotal_funds(objects[15].toString());
			} else {
				log.setTotal_funds(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[16]!= null) {
				log.setShip_to_different_address(objects[16].toString());
			} else {
				log.setShip_to_different_address(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return log;
		}).collect(Collectors.toList());

		return dealerlist;


	}

}
