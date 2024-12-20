package com.jwtAuth.wrappers;

import java.io.Serializable;
import java.util.List;

import com.jwtAuth.model.Count;
import com.jwtAuth.model.querie;
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
	
	public String totalFunds;
}
