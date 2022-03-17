package com.anniyamtech.bbps.service;

import java.util.List;
import java.util.Optional;

import com.anniyamtech.bbps.entity.BillerListReq;
import com.anniyamtech.bbps.requestDto.BillerListReqDto;
import com.anniyamtech.bbps.responseDto.BillerListResponse;

public interface BillerListService {
	public BillerListResponse addBiller(BillerListReqDto districtdto);
	public BillerListReqDto fetchByRefId(String refId);
	public List<BillerListReqDto> fetchAllBillerDetails();
	public void updateBillerList(BillerListReqDto BillerListReqDto, String refId);
	public void deleteByRefId(String refId);
	//public  Optional<BillerListReq> getBillersById(String id);
}
