package com.jwtAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtAuth.exceptions.InSufficientInputException;
import com.jwtAuth.model.DealerAllDetails;
import com.jwtAuth.model.DealerDetails;
import com.jwtAuth.model.DealerLogin;
import com.jwtAuth.model.StatesModel;
import com.jwtAuth.response.Response;
import com.jwtAuth.services.CommonServices;
import com.jwtAuth.services.DealerSignupServices;
import com.jwtAuth.utils.IsEmptyUtil;
import com.jwtAuth.wrappers.CommonWrapper;
import com.jwtAuth.wrappers.DealerSignupWrappers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class DealerController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("DealerRegsserviceimpl")
	private DealerSignupServices dataServices;

	@RequestMapping(value = "/Dealeredtails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response dealerLogin(@RequestBody DealerDetails objDealerSignup)
			throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		DealerSignupWrappers wrapper = new DealerSignupWrappers();
		log.info(strRequestID + "::::Data is save or not:::::INPUTS ARE::::" + objDealerSignup.toString());

		String listOfData = dataServices.dealerdetailsatlogin(objDealerSignup, strRequestID);
		wrapper.setDealerdetails(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}

	
	
	
	@RequestMapping(value = "/updateDealeredtails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response dealerLogin(@RequestBody DealerAllDetails objDealer)
			throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		DealerSignupWrappers wrapper = new DealerSignupWrappers();
		log.info(strRequestID + "::::Data is save or not:::::INPUTS ARE::::" + objDealer.toString());

		String listOfData = dataServices.updateDealerDetails(objDealer, strRequestID);
		wrapper.setDealerdetails(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
	
	
	
	
	@RequestMapping(value = "/getdealerdetailsbyid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getStatesByCountries(@RequestBody DealerAllDetails states) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		DealerSignupWrappers wrapper = new DealerSignupWrappers();

		if (IsEmptyUtil.isEmptyObject(states.getId())) {
			throw new InSufficientInputException("invalid inputs");
		} else {

			List<DealerAllDetails> sDto = dataServices.getDealersByIdService(states, strRequestID);

			wrapper.setDealerList(sDto);
			wrapper.setServerIp(this.getClientIp(request));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		}

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}

	
	
	
	
	
	public String getClientIp(HttpServletRequest request) {
//		"Client IP: " +
		return (request.getHeader("X-Forwarded-For") != null ? request.getHeader("X-Forwarded-For")
				: request.getRemoteAddr());
	}
}
