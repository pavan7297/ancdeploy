package com.jwtAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtAuth.model.Count;
import com.jwtAuth.model.querie;
import com.jwtAuth.response.Response;
import com.jwtAuth.services.BlogServices;
import com.jwtAuth.services.SuperAdminServices;
import com.jwtAuth.wrappers.CommonWrapper;
import com.jwtAuth.wrappers.SuperAdminWrappers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class SuperAdmin {
	
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("superadminServicesimpl")
	private SuperAdminServices superadminServices;
	
	
	
	@RequestMapping(value = "/dealerscount", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response dealersCount() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.getDealersCountService(strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setCounts(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	
	
	
	@RequestMapping(value = "/userscount", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response userssCount() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.getUsersCountService(strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setCounts(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	
	@RequestMapping(value = "/totalfunds", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response totalsfunds() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.getTotalFunds(strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setTotalFunds(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	
	
	@RequestMapping(value = "/userspercentage", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response usersPercentage() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.getTotalFunds(strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setTotalFunds(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	
	@RequestMapping(value = "/dealerPercentage", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response dealerPercentage() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.dealerPercentageServices(strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setTotalFunds(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	@RequestMapping(value = "/totalfundsPercentage", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response totalfundsPercentage() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.totalfundsPercentageServices(strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setTotalFunds(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}

	
}
