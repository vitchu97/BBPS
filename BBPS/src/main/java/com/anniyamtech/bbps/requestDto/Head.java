package com.anniyamtech.bbps.requestDto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Head {

	private String refId;
	
	private String ver;
	
	private String origInst;
	
	private Date ts;
}
