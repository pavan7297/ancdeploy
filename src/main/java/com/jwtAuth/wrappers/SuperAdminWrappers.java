package com.jwtAuth.wrappers;

import java.io.Serializable;
import java.util.List;

import com.jwtAuth.model.GetTeamList;
import com.jwtAuth.model.getAllDealers;
import com.jwtAuth.response.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SuperAdminWrappers extends Response implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -2766641024702080028L;
	

//	public List<Count> counts;
	

	public String counts;
	
	public String userCounts;
	
	public String fundsCounts;
	
	public String upercentageCounts;
	
	public String dprecentageCounts;

	public String tfprecentageCounts;

	public String totalFunds;
	
	public String addToTeam;
	
	public List<GetTeamList> getTeamList;
	
	public List<GetTeamList> TeamMember;
	
	public String updatePerson;
	
	public String deletePerson;
	
	public List<getAllDealers> getAllDealers;
}
