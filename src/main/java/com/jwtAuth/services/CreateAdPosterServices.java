package com.jwtAuth.services;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.CreateAdPost;
import com.jwtAuth.model.GetAllAds;
import com.jwtAuth.model.UpdateAd;

public interface CreateAdPosterServices {

	public String createAdPoster(CreateAdPost creAdPost, String strRequestID) throws Exception, SQLDataException;

	public List<GetAllAds> getAllAd(String strRequestID) throws DataNotFoundException, SQLException;

	public List<GetAllAds> getAdByIdServices(GetAllAds ads, String strRequestID)
			throws DataNotFoundException, SQLException;

	public String updateAdServices(UpdateAd creAdPost, String strRequestID) throws Exception, SQLDataException;

}
