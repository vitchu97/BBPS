package com.anniyamtech.bbps.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anniyamtech.bbps.entity.BillerListReq;
import com.anniyamtech.bbps.repository.BillerListRepository;
import com.anniyamtech.bbps.requestDto.BillerBankReq;
import com.anniyamtech.bbps.requestDto.BillerListReqDto;
import com.anniyamtech.bbps.requestDto.Head;
import com.anniyamtech.bbps.requestDto.Search;
import com.anniyamtech.bbps.responseDto.BillerListResponse;
import com.anniyamtech.bbps.service.BillerListService;
import com.anniyamtech.bbps.utils.BbpsAes;
import com.anniyamtech.bbps.utils.JulianDateConverter;
import com.google.gson.Gson;

@Service
public class BillerListServiceImp implements BillerListService {
	@Autowired
	BillerListRepository billerListRepository;

	BillerBankReq bankReq = new BillerBankReq();
	Head head = new Head();
	Search search = new Search();
	BbpsAes bbps = new BbpsAes();
	Gson gson = new Gson();

	@Override
	public BillerListResponse addBiller(BillerListReqDto billerListReqDto) {

		String refId = JulianDateConverter.generationLogic();

		BillerListReq billerListReq = new BillerListReq();
		billerListReq.setVer(billerListReqDto.getHead().getVer());
		billerListReq.setRefId(refId);
		billerListReq.setOrigInst(billerListReqDto.getHead().getOrigInst());
		billerListReq.setTs(billerListReqDto.getHead().getTs());
		billerListReq.setCategory(billerListReqDto.getSearch().getCategory());
		billerListReq.setLastUpdated(billerListReqDto.getSearch().getLastUpdated());
		System.out.println("<=====================" + billerListReq + "====================>");
		billerListRepository.save(billerListReq);

		String requestBody = gson.toJson(billerListReqDto);

		String EncryptedData = bbps.encryption(requestBody);

		bankReq.setRequestMsg(EncryptedData);
		bankReq.setAgentInstitutionId("OU01");

		String bankReqJson = gson.toJson(bankReq);

		System.out.println("<==============" + bankReqJson + "==============>");

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject("https://45.114.78.159:9090/getBillerList", bankReqJson,
				String.class);

		String DecryptedData = bbps.decryption(response);

		BillerListResponse billerResponseDto = gson.fromJson(DecryptedData, BillerListResponse.class);

		return billerResponseDto;
	}

	@Override
	public BillerListReqDto fetchByRefId(String refId) {
		Optional<BillerListReq> billerListReq = billerListRepository.findById(refId);
		BillerListReq billerList = billerListReq.get();
		BillerListReqDto billerListDTO = new BillerListReqDto();

		billerListDTO.getHead().setRefId(billerList.getRefId());
		billerListDTO.getHead().setOrigInst(billerList.getOrigInst());
		billerListDTO.getHead().setVer(billerList.getVer());
		billerListDTO.getHead().setTs(billerList.getTs());
		billerListDTO.getSearch().setCategory(billerList.getCategory());
		billerListDTO.getSearch().setLastUpdated(billerList.getLastUpdated());

		return billerListDTO;

	}

	@Override
	public void updateBillerList(BillerListReqDto BillerListReqDto, String refId) {

	}

	@Override
	public void deleteByRefId(String refId) {

	}

	@Override
	public List<BillerListReqDto> fetchAllBillerDetails() {

		List<BillerListReq> billerListReqs = billerListRepository.findAll();
		List<BillerListReqDto> billerListReqDtos = new ArrayList<BillerListReqDto>();

		for (BillerListReq billerList : billerListReqs) {

			BillerListReqDto billerListDTO = new BillerListReqDto();

			billerListDTO.getHead().setRefId(billerList.getRefId());
			billerListDTO.getHead().setOrigInst(billerList.getOrigInst());
			billerListDTO.getHead().setVer(billerList.getVer());
			billerListDTO.getHead().setTs(billerList.getTs());
			billerListDTO.getSearch().setCategory(billerList.getCategory());
			billerListDTO.getSearch().setLastUpdated(billerList.getLastUpdated());

			billerListReqDtos.add(billerListDTO);
		}
		return billerListReqDtos;
	}

	/*
	 * @Override public Optional<BillerListReq> getBillersById(String id) { return
	 * billerListRepository.findById(id); }
	 */

}
