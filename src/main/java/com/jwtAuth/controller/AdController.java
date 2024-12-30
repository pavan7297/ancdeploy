package com.jwtAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtAuth.model.Blogs;
import com.jwtAuth.model.CreateAdPost;
import com.jwtAuth.model.GetAllAds;
import com.jwtAuth.response.Response;
import com.jwtAuth.services.CreateAdPosterServices;
import com.jwtAuth.wrappers.AdPosterWrappers;
import com.jwtAuth.wrappers.BlogWrappers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class AdController {

	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("AdPosterServiceimpl")
	private CreateAdPosterServices dataServices;

	@RequestMapping(value = "/createaAd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response createAdPoster(@RequestBody CreateAdPost createPost) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		AdPosterWrappers wrapper = new AdPosterWrappers();
		log.info(strRequestID + "::::Create the Ad Data:::::::save with:::::"+createPost.toString());

		String listOfData = dataServices.createAdPoster(createPost, strRequestID);
		wrapper.setCreateAd(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
	
	
	@RequestMapping(value = "/getAllAdPostData", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	private Response getAllAdPostData() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		AdPosterWrappers wrapper = new AdPosterWrappers();
		log.info(strRequestID + "::::Get All Blog Data:::::::");

		List<GetAllAds> listOfData = dataServices.getAllAd(strRequestID);
		wrapper.setAdList(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
	
	
	@RequestMapping(value = "/getAdPostById", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response getAdPostById(@RequestBody GetAllAds getAllAds) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		AdPosterWrappers wrapper = new AdPosterWrappers();
		log.info(strRequestID + "::::Get All Blog Data:::::::");

		List<GetAllAds> listOfData = dataServices.getAdByIdServices(getAllAds,strRequestID);
		wrapper.setAdList(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}


	
}
