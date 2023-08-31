package com.java.cal;

import java.util.Calendar;

public class CalEx2 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println("Current Calenders Year : "+cal.YEAR);
		System.out.println("Current Calenders Year : "+cal.DATE);
		int month = cal.get(Calendar.MONTH);
		month++;
		System.out.println("Month : "+month);
	}

}
