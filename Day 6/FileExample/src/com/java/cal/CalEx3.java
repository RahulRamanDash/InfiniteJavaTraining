package com.java.cal;

import java.util.Calendar;

public class CalEx3 {
	public static void main(String[] args) {
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, -15);
		System.out.println("15 Days Ago : "+calender.getTime());
		calender.add(Calendar.MONTH, 4);
		System.out.println("4 Months Later : "+calender.getTime());
		calender.add(Calendar.YEAR, 2);
		System.out.println("2 Years Ago : "+calender.getTime());
	}

}
