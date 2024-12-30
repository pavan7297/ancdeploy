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
import com.jwtAuth.model.CreateAdPost;
import com.jwtAuth.model.GetAllAds;
import com.jwtAuth.model.UpdateAd;
import com.jwtAuth.services.CreateAdPosterServices;
import com.jwtAuth.utils.CommonConstants;

import lombok.extern.slf4j.Slf4j;

@Service("AdPosterServiceimpl")
@Slf4j
public class CreateAdPosterServicesImpl implements CreateAdPosterServices {

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
	public String createAdPoster(CreateAdPost creAdPost, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
	    String output = null;

		try {
			// Establish the connection
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);

			// Prepare the callable statement
			cs = connection.prepareCall("{call create_advertisement(?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(1, creAdPost.getPostdescription());
			cs.setString(2, creAdPost.getPostimg());
			cs.setString(3, creAdPost.getPostuser_id());
			cs.setString(4, creAdPost.getPoststate());
			cs.setString(5, creAdPost.getPostcity());
			cs.setString(6, creAdPost.getPostruntime());
			cs.setString(7, creAdPost.getPoststatus());

			log.info(strRequestID + ":::::::::::::" + cs.toString());
			output = objAppdata.saveData(cs.toString());

			// Execute the callable statement
//	        boolean result = cs.execute();
//	        log.info(strRequestID + " - Procedure executed successfully with result: " + result);

			// Optionally, process results if needed
//	        output = "Procedure executed successfully";
		} catch (SQLException e) {
			log.error("SQL Exception occurred: ", e);
			throw e;
		} finally {
			// Ensure resources are closed
			if (cs != null)
				cs.close();
			if (connection != null)
				connection.close();
		}
		return output;

	}

	@Override
	public List<GetAllAds> getAllAd(String strRequestID) throws DataNotFoundException, SQLException {
		PreparedStatement cs = null;
		Connection connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
		try {

			cs = connection.prepareCall("{call get_all_advertisements()}");
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {
			connection.close();
		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<GetAllAds> adsList = data.stream().map((Object[] objects) -> {
			GetAllAds ads = new GetAllAds();

			if (objects[0] != null) {
				ads.setPostid(objects[0].toString());
			} else {
				ads.setPostid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				ads.setPostdescription(objects[1].toString());
			} else {
				ads.setPostdescription(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				ads.setPostimg(objects[2].toString());
			} else {
				ads.setPostimg(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				ads.setDealername(objects[3].toString());
			} else {
				ads.setDealername(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				ads.setDealernumber(objects[4].toString());
			} else {
				ads.setDealernumber(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				ads.setState(objects[5].toString());
			} else {
				ads.setState(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				ads.setCity(objects[6].toString());
			} else {
				ads.setCity(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				ads.setRuntime(objects[6].toString());
			} else {
				ads.setRuntime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				ads.setPoststatus(objects[7].toString());
			} else {
				ads.setPoststatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return ads;
		}).collect(Collectors.toList());

		return adsList;

	}

	@Override
	public List<GetAllAds> getAdByIdServices(GetAllAds adslist, String strRequestID)
			throws DataNotFoundException, SQLException {
		PreparedStatement cs = null;
		Connection connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
		try {

			cs = connection.prepareCall("{call get_advertisement_by_id(?)}");
			cs.setString(1, adslist.getPostid());

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {
			connection.close();
		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<GetAllAds> adsList = data.stream().map((Object[] objects) -> {
			GetAllAds ads = new GetAllAds();

			if (objects[0] != null) {
				ads.setPostid(objects[0].toString());
			} else {
				ads.setPostid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				ads.setPostdescription(objects[1].toString());
			} else {
				ads.setPostdescription(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				ads.setPostimg(objects[2].toString());
			} else {
				ads.setPostimg(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				ads.setDealername(objects[3].toString());
			} else {
				ads.setDealername(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				ads.setDealernumber(objects[4].toString());
			} else {
				ads.setDealernumber(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				ads.setState(objects[5].toString());
			} else {
				ads.setState(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				ads.setCity(objects[6].toString());
			} else {
				ads.setCity(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				ads.setRuntime(objects[6].toString());
			} else {
				ads.setRuntime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				ads.setPoststatus(objects[7].toString());
			} else {
				ads.setPoststatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return ads;
		}).collect(Collectors.toList());

		return adsList;

	}

	@Override
	public String updateAdServices(UpdateAd creAdPost, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call update_post_details(?,?,?,?,?)}");
			cs.setString(1, creAdPost.getPostid());
			cs.setString(2, creAdPost.getPostdescription());
			cs.setString(3, creAdPost.getPostimg());
			cs.setString(4, creAdPost.getPostlocation());
			cs.setString(5, creAdPost.getPoststatus());

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.saveData(cs.toString());
		return output;
	}

}
