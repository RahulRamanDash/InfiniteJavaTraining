package com.java.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
	SimpleDateFormat sdf = new SimpleDateFormat();
	Date date = new Date();
	String dateStr = sdf.format(date);
	java.util.Date search;
	try {
		search = sdf.parse(dateStr);
		java.sql.Date sqlDate = new java.sql.Date(search.getTime());
		System.out.println(sqlDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}