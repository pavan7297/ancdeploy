package com.jwtAuth.wrappers;

import java.io.Serializable;
import java.util.List;

import com.jwtAuth.model.Blogs;
import com.jwtAuth.model.GetAllAds;
import com.jwtAuth.response.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdPosterWrappers extends Response implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -8662432977724003719L;

	
	public String createAd;
	public List<GetAllAds> adList;
	
	
}
