package com.anniyamtech.bbps.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anniyamtech.bbps.config.ResponseClass;
import com.anniyamtech.bbps.entity.BillerListReq;
import com.anniyamtech.bbps.exception.InvalidDataException;
import com.anniyamtech.bbps.exception.InvalidIdException;
import com.anniyamtech.bbps.requestDto.BillerListReqDto;
import com.anniyamtech.bbps.service.Impl.BillerListServiceImp;

@RestController
@RequestMapping(value = "/api")
public class BillerListController {
	// Logger Object

	@Autowired
	BillerListServiceImp billerListServiceImp;

	// district

	// Add
	@PostMapping("/BillerList")
	public ResponseEntity<Object> addBiller(@RequestBody BillerListReqDto billerListReqDto) {
		try {
			billerListServiceImp.addBiller(billerListReqDto);
			return new ResponseEntity<>(new ResponseClass("Data added successfully", billerListReqDto),
					HttpStatus.CREATED);

		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			/*
			 * throw new InvalidDataException("Invalid Credentials Entered");
			 */
		}
		return null;
	}

	// fetch

	/*
	 * @GetMapping("/BillerList/{id}") public ResponseEntity<Object>
	 * fetchBillersById(@PathVariable(value = "id") String refId) { try {
	 * BillerListReqDto billerList = billerListServiceImp.fetchByRefId(refId);
	 * return new ResponseEntity<>(new ResponseClass("Data Fetched successfully",
	 * billerList), HttpStatus.OK);
	 * 
	 * } catch (RuntimeException e) { e.printStackTrace(); // throw new
	 * InvalidIdException("Invalid Id Entered No data found for Id : " + refId); }
	 * return null; }
	 */
	

	// fetchAll
	@GetMapping("/BillerList")
	public ResponseEntity<Object> fetchAllBillers() {
		try {
			List<BillerListReqDto> billerDetails = billerListServiceImp.fetchAllBillerDetails();
			return new ResponseEntity<>(new ResponseClass("Datas Fetched successfully", billerDetails), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// return new ResponseEntity<>("Unable to fetch All district data ",
			// HttpStatus.METHOD_NOT_ALLOWED);
		}
		return null;
	}

	// Update
	@PutMapping("/BillerList/{id}")
	public ResponseEntity<Object> updateBiller(@PathVariable(value = "id") String refId,
			@Valid @RequestBody BillerListReqDto billerListReqDto) {
		try {
			billerListServiceImp.updateBillerList(billerListReqDto, refId);
			return new ResponseEntity<>(
					new ResponseClass("Data Updated successfully for Id : " + refId, billerListReqDto), HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new InvalidDataException("Invalid Credentials Entered data cannot be updated for Id : " + refId);
		}

	}

	// Delete
	@DeleteMapping("/BillerList/{id}")
	private ResponseEntity<Object> deleteBiller(@PathVariable("id") String refId) {
		try {
			billerListServiceImp.deleteByRefId(refId);
			return new ResponseEntity<>(new ResponseClass("District deleted for Id : " + refId), HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new InvalidIdException("Invalid Id Entered No data found for Id : " + refId);
		}
	}

	/*
	 * @GetMapping("/BillerList/{refId}") private Optional<BillerListReq>
	 * getBillersById(@PathVariable("refId") String refId) { try { return
	 * billerListServiceImp.getBillersById(refId); } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } return null; }
	 */

}
