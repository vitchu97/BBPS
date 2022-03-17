package com.anniyamtech.bbps.responseDto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillerListResponse {
	private static final long serialVersionUID = 1L;
	
	private Head head;
	
	private Reason reason;
	
	private List<Billers> billers;
	
}
