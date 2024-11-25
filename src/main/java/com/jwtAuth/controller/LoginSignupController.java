package com.jwtAuth.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.exceptions.InSufficientInputException;
import com.jwtAuth.model.DealerRegistration;
import com.jwtAuth.model.DealerSignup;
import com.jwtAuth.response.Response;
import com.jwtAuth.services.CommonServices;
import com.jwtAuth.services.DealerSignupServices;
import com.jwtAuth.wrappers.CommonWrapper;
import com.jwtAuth.wrappers.DealerSignupWrappers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoginSignupController {
	
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("DealerRegsserviceimpl")
	private DealerSignupServices dataServices;

	@RequestMapping(value = "/DealerRegistrationsignup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response dealerRegisration(@RequestBody DealerSignup objDealerSignup)
			throws InSufficientInputException, DataNotFoundException, SQLException {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		DealerSignupWrappers wrapper = new DealerSignupWrappers();
		log.info(strRequestID + "::::Data is save or not:::::INPUTS ARE::::" + objDealerSignup.toString());

		String listOfData = dataServices.saveDealerRegistration(objDealerSignup, strRequestID);
		wrapper.setOutput(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
	
	
	
	public String getClientIp(HttpServletRequest request) {
//		"Client IP: " +
	return (request.getHeader("X-Forwarded-For") != null ? request.getHeader("X-Forwarded-For")
			: request.getRemoteAddr());
}
}
