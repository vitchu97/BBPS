package com.anniyamtech.bbps.responseDto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Billers {
	private String billerId;
	private String billerName;
	private String billerAliasName;
	private String billerCategoryName;
	private Date lastUpdated;
			
	
}
