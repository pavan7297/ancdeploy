package com.jwtAuth.model;

import lombok.Data;

@Data
public class getAllDealers {
	
		private String dealer_id ;
	    private String user_id ;
	    private String first_name ;
	    private String last_name ;
	    private String image_url ;
	    private String company_name ;
	    private String country ;
	    private String address1 ;
	    private String address2 ;
	    private String city ;
	    private String state ;
	    private String zipcode ;
	    private String phone ;
	    private String email ;
	    private String username ;
	    private String total_funds ;
	    private String ship_to_different_address;

}
