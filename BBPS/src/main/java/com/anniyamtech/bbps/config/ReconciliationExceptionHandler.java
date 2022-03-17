package com.anniyamtech.bbps.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ReconciliationExceptionHandler {

//	@ExceptionHandler(value = { IncorrectDateFormat.class })
//	public ResponseEntity<Object> incorrectDateFormat(HttpServletRequest request,
//	  		IncorrectDateFormat ex) {
//	
//		GenericResponse resp = getResponse(MessageConstant.defaultErrorStatus, MessageConstant.defaultErrorCode,
//				MessageConstant.wrongDateFormat, MessageConstant.wrongDateFormat, MessageConstant.defaultUserdata);
//		return new ResponseEntity<>(resp, ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
//
//	}
//
//	@ExceptionHandler(value = { DuplicateTransactionIdFoundInFile.class })
//	public ResponseEntity<Object> duplicateTransactionIdFoundInFile(HttpServletRequest request,
//			DuplicateTransactionIdFoundInFile ex) {
//		GenericResponse resp = getResponse(MessageConstant.defaultErrorStatus, MessageConstant.defaultErrorCode,
//				MessageConstant.defaultErrorMessage, MessageConstant.duplicateTrascationIdFoundInFile,
//				MessageConstant.defaultUserdata);
//		return new ResponseEntity<>(resp, ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
//
//	}
//
//	@ExceptionHandler(value = { DuplicateTxnIdFoundInDb.class })
//	public ResponseEntity<Object> DuplicateTxnIdFoundInDb(HttpServletRequest request,
//			DuplicateTransactionIdFoundInFile ex) {
//		GenericResponse resp = getResponse(MessageConstant.defaultErrorStatus, MessageConstant.defaultErrorCode,
//				MessageConstant.defaultErrorMessage, MessageConstant.duplicateTrascationIdFoundInDataBase,
//				MessageConstant.defaultUserdata);
//		return new ResponseEntity<>(resp, ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
//
//	}
//
//	
//
//	@ExceptionHandler(value = { UploadedFileFormatIsIncorrect.class })
//	public ResponseEntity<Object> UploadedFileFormatIsIncorrect(HttpServletRequest request, Exception ex) {
//		GenericResponse resp = getResponse(MessageConstant.defaultErrorStatus, MessageConstant.defaultErrorCode,
//				MessageConstant.defaultErrorMessage, MessageConstant.wrongFileSelectedMessage,
//				MessageConstant.defaultUserdata);
//		return new ResponseEntity<>(resp, ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
//
//	}
//	@ExceptionHandler(value = { Exception.class })
//	public ResponseEntity<Object> exception(HttpServletRequest request, Exception ex) {
//		ex.printStackTrace();
//		GenericResponse resp = getResponse(MessageConstant.defaultErrorStatus, MessageConstant.defaultErrorCode,
//				MessageConstant.defaultErrorMessage, MessageConstant.defaultUserMessage,
//				MessageConstant.defaultUserdata);
//		return new ResponseEntity<>(resp, ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
//
//	}
//	private GenericResponse getResponse(String status, String errorCode, String errorMesg, String erroDesc,
//			Object userData) {
//		GenericResponse objGenericResponse = new GenericResponse();
//		objGenericResponse.setStatus(status);
//		objGenericResponse.setErrorCode(errorCode);
//		objGenericResponse.setErrorDescription(errorMesg);
//		objGenericResponse.setUserDisplayMesg(erroDesc);
//		objGenericResponse.setData(userData);
//		return objGenericResponse;
//	}
}
