package com.jwtAuth.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.util.List;

import com.jwtAuth.model.AddTeamMembers;
import com.jwtAuth.model.Blogs;
import com.jwtAuth.model.Count;
import com.jwtAuth.model.DeleteTeamMember;
import com.jwtAuth.model.GetTeamList;
import com.jwtAuth.model.UpdateTeamMember;
import com.jwtAuth.model.getAllDealers;

public interface SuperAdminServices {

	public String getDealersCountService(String strRequestID) throws Exception, SQLDataException;

	public String getUsersCountService(String strRequestID) throws Exception, SQLDataException;

	public String getTotalFunds(String strRequestID) throws Exception, SQLDataException;

	public String userPercentageServices(String strRequestID) throws Exception, SQLDataException;

	public String dealerPercentageServices(String strRequestID) throws Exception, SQLDataException;

	public String totalfundsPercentageServices(String strRequestID) throws Exception, SQLDataException;

	public String addTeam(AddTeamMembers team, String strRequestID) throws Exception, SQLDataException;
	
	public List<GetTeamList> getTeamServices(String strRequestID) throws Exception, SQLDataException ;
	
	public List<GetTeamList> getTeamByIdServices(GetTeamList getTeamList, String strRequestID) throws Exception, SQLDataException ;
	
	public String updateTeamMembersServices(UpdateTeamMember team, String strRequestID) throws Exception, SQLDataException;

	public String deleteTeamMembersServices(DeleteTeamMember team, String strRequestID) throws Exception, SQLDataException;
	
	public List<getAllDealers> getAllDealersServices(String strRequestID) throws Exception, SQLDataException ;


	

}
