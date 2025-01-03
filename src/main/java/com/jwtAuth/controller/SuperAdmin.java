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

import com.jwtAuth.model.AddTeamMembers;
import com.jwtAuth.model.Blogs;
import com.jwtAuth.model.Count;
import com.jwtAuth.model.DeleteTeamMember;
import com.jwtAuth.model.GetTeamList;
import com.jwtAuth.model.UpdateTeamMember;
import com.jwtAuth.model.getAllDealers;
import com.jwtAuth.model.querie;
import com.jwtAuth.response.Response;
import com.jwtAuth.services.BlogServices;
import com.jwtAuth.services.SuperAdminServices;
import com.jwtAuth.wrappers.BlogWrappers;
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
	
	
	
	@RequestMapping(value = "/countdata", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response AllCounts() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.getDealersCountService(strRequestID);
		
		String user = superadminServices.getUsersCountService(strRequestID);
		
		String funds = superadminServices.getTotalFunds(strRequestID);
		
		String upercentage = superadminServices.userPercentageServices(strRequestID);
		
		String dprecentage = superadminServices.dealerPercentageServices(strRequestID);
		
		String tfprecentage = superadminServices.totalfundsPercentageServices(strRequestID);


		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setCounts(sDto);
		wrapper.setUserCounts(user);
		wrapper.setFundsCounts(funds);
		wrapper.setUpercentageCounts(upercentage);
		wrapper.setDprecentageCounts(dprecentage);
		wrapper.setTfprecentageCounts(tfprecentage);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	
	
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
	
	
	@RequestMapping(value = "/addteam", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response addTeam(@RequestBody AddTeamMembers addTeamMembers) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		log.info(strRequestID + "::::Create the Blog Data:::::::save with:::::"+addTeamMembers.toString());

		String listOfData = superadminServices.addTeam(addTeamMembers, strRequestID);
		wrapper.setAddToTeam(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
	
	
	@RequestMapping(value = "/getTeam", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getTeam() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		List<GetTeamList> sDto = superadminServices.getTeamServices(strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setGetTeamList(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	@RequestMapping(value = "/getTeamById", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getTeamById(@RequestBody GetTeamList getTeamList) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		List<GetTeamList> sDto = superadminServices.getTeamByIdServices(getTeamList,strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setTeamMember(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
	
	@RequestMapping(value = "/updateTeamMember", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateTeamMember(@RequestBody UpdateTeamMember teamMember) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.updateTeamMembersServices(teamMember,strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setUpdatePerson(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.updatePerson.toString());

		return wrapper;
	}

	
	@RequestMapping(value = "/deleteTeamMember", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response deleteTeamMember(@RequestBody DeleteTeamMember teamMember) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		String sDto = superadminServices.deleteTeamMembersServices(teamMember,strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setDeletePerson(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.deletePerson.toString());

		return wrapper;
	}
	
	
	@RequestMapping(value = "/getAllDealers", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllDealers() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");
		
		List<getAllDealers> sDto = superadminServices.getAllDealersServices(strRequestID);

		SuperAdminWrappers wrapper = new SuperAdminWrappers();
		wrapper.setGetAllDealers(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());

		return wrapper;
	}
	
}
