package com.jwtAuth.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Response {
	String status;
	Integer responseCode;
	List<String> errorsMsgs;
	String output;
	String serverIp;
	String port;
	String count;


}
