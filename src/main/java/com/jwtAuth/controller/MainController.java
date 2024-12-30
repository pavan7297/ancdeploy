package com.jwtAuth.controller;

import java.sql.SQLException;
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

import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.exceptions.InSufficientInputException;
import com.jwtAuth.model.Countrys;
import com.jwtAuth.model.DealerDetails;
import com.jwtAuth.model.DealerRegistration;
import com.jwtAuth.model.StatesModel;
import com.jwtAuth.model.querie;
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
public class MainController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("commonserviceimpl")
	private CommonServices dataServices;
	

	@RequestMapping(value = "/wish", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	private String wish() {
		return "welcome to the web services";
	}

	
	@RequestMapping(value = "/country", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllCountrys() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		List<Countrys> sDto = dataServices.CountrysService(strRequestID);

		CommonWrapper wrapper = new CommonWrapper();
		wrapper.setCountrylist(sDto);
		wrapper.setServerIp(this.getClientIp(request));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}


	@RequestMapping(value = "/states", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getStatesByCountries(@RequestBody StatesModel states) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		CommonWrapper wrapper = new CommonWrapper();

		if (IsEmptyUtil.isEmptyObject(states.getCountry_code())) {
			throw new InSufficientInputException("invalid inputs");
		} else {

			List<StatesModel> sDto = dataServices.stateByCountrieService(states, strRequestID);

			wrapper.setStateslist(sDto);
			wrapper.setServerIp(this.getClientIp(request));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		}

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	
	
	@RequestMapping(value = "/postquerie", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response postQuerie(@RequestBody querie objQuerie)
			throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		CommonWrapper wrapper = new CommonWrapper();
		log.info(strRequestID + "::::Data is save or not:::::INPUTS ARE::::" + objQuerie.toString());

		String listOfData = dataServices.querieServices(objQuerie, strRequestID);
		wrapper.setDataquerie(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
	
	
	
	
	
	@RequestMapping(value = "/listofquries", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response listofquries() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		List<querie> sDto = dataServices.getallquerielistService(strRequestID);

		CommonWrapper wrapper = new CommonWrapper();
		wrapper.setQueriedata(sDto);
		wrapper.setServerIp(this.getClientIp(request));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}

	

	@RequestMapping(value = "/deletequries", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response deletequries(@RequestBody querie querie) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		String sDto = dataServices.deletequerieService(querie, strRequestID);

		CommonWrapper wrapper = new CommonWrapper();
		wrapper.setDataquerie(sDto);
		wrapper.setServerIp(this.getClientIp(request));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	

	
	
	
	public String getClientIp(HttpServletRequest request) {
//			"Client IP: " +
		return (request.getHeader("X-Forwarded-For") != null ? request.getHeader("X-Forwarded-For")
				: request.getRemoteAddr());
	}

}
