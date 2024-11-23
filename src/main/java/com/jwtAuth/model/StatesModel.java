package com.jwtAuth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StatesModel {

	private String states_id;

	private String states_state_name;

	private String country_code;

}
