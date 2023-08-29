package com.java.esc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDiff {
	public void show(String startDate, String endDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date stDate = sdf.parse(startDate);
		Date sDate = sdf.parse(endDate);
		long diff = sDate.getTime() -stDate.getTime();
		long days =(diff/ (1000* 60 *60 * 24));
		days++;
		System.out.println("Total Leave Applied Days :"+days );
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Leave start date");
		String startDate = sc.next();
		System.out.println("Enter Leave End date");
		String endDate= sc.next();
		DateDiff obj = new DateDiff();
		
		try {
			obj.show(startDate, endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
