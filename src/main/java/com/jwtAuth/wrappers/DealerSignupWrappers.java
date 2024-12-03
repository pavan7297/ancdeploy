package com.jwtAuth.wrappers;

import java.io.Serializable;
import java.util.List;

import com.jwtAuth.model.DealerAllDetails;
import com.jwtAuth.model.DealerLogin;
import com.jwtAuth.model.DealerSignup;
import com.jwtAuth.model.StatesModel;
import com.jwtAuth.response.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DealerSignupWrappers extends Response implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7519631066804903329L;

	public String dealerSignup;
	public List<DealerSignup> dealerSignupList;
	public List<DealerLogin> dealerLogList;
	public String dealerdetails;
	public List<DealerAllDetails> dealerList;

	
}
