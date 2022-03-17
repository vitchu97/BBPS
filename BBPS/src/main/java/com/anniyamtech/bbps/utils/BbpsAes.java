package com.anniyamtech.bbps.utils;

import com.mgs.bbps.security.SecurityUtils;

public class BbpsAes {

	SecurityUtils utils = new SecurityUtils();
	String key = "863c3eeacbf53d42d01a56b241e95bff";

	public String encryption(String data) {
		String encDataGcm;
		try {
			encDataGcm = utils.encryptAesGcm(data, key);
			return encDataGcm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String decryption(String encDataGcm) {

		try {
			String decDataGcm = utils.decryptAesGcm(encDataGcm, key);
			return decDataGcm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
