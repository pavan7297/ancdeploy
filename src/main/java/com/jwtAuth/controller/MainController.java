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
import com.jwtAuth.model.DealerRegistration;
import com.jwtAuth.model.StatesModel;
import com.jwtAuth.response.Response;
import com.jwtAuth.services.CommonServices;
import com.jwtAuth.utils.IsEmptyUtil;
import com.jwtAuth.wrappers.CommonWrapper;

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

	@GetMapping("/wish")
	private String wish() {
		return "welcome to the web services";
	}

	@GetMapping("/county")
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

	@GetMapping("/states")
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

	
	
	
	public String getClientIp(HttpServletRequest request) {
//			"Client IP: " +
		return (request.getHeader("X-Forwarded-For") != null ? request.getHeader("X-Forwarded-For")
				: request.getRemoteAddr());
	}

}
