package com.anniyamtech.bbps.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class JulianDateConverter {

	public static String generationLogic() {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
	
		  int n=27;
		StringBuilder sb = new StringBuilder(n);
     
		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));

		}
		String Y = new SimpleDateFormat("yy").format(new Date());
		String julianDateString = Y.substring(1);

		Calendar date = Calendar.getInstance();
		int day = LocalDate.now().getDayOfYear();

		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);

		String julian = julianDateString + day + hour + minute;
		

		return sb+julian;

	}

	public static String generationLogic2() {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
	
		  int n=12;
		StringBuilder sb = new StringBuilder(n);
     
		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));

		}
		String Y = new SimpleDateFormat("yy").format(new Date());
		String julianDateString = Y.substring(1);

		///Calendar date = Calendar.getInstance();
		int day = LocalDate.now().getDayOfYear();

		String julian = julianDateString + day ;
		

		return sb+julian;

	}
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println(generationLogic());
	 * System.out.println(generationLogic2()); }
	 */

}
