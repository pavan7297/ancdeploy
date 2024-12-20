package com.jwtAuth.wrappers;

import java.io.Serializable;
import java.util.List;

import com.jwtAuth.model.Countrys;
import com.jwtAuth.model.StatesModel;
import com.jwtAuth.model.querie;
import com.jwtAuth.res.StatesRes;
import com.jwtAuth.response.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonWrapper extends Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8013268807414294202L;
	public String Dataquerie;
	public List<StatesModel> stateslist;
	public List<Countrys> countrylist;
	public List<querie> queriedata;
}
