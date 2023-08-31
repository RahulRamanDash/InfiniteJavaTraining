package com.java.cal;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CalEx5 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Date(year-month-date) : ");
		String str = sc.next();
		
		try {
			Date date = sdf.parse(str);
			System.out.println("Original Date is : "+date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			System.out.println("Calendar Date is "+cal.getTime());
			cal.add(Calendar.DATE, 15);
			cal.add(Calendar.MONTH, 5);
			
			Date updatedate = cal.getTime();
			System.out.println("Updated Date is :"+updatedate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
