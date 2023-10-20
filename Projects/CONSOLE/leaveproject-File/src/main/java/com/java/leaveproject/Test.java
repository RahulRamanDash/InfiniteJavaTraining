package com.java.leaveproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar calender = Calendar.getInstance();
	calender.add(Calendar.DATE, -1);
	System.out.println("Priv dt is "+calender.getTime());
	Scanner sc = new Scanner(System.in);
	String inpt = sc.next();
	Date dt;
	
	try {
		dt = sdf.parse(inpt);
		
		calender.setTime(dt);
		System.out.println("Dt is "+calender.getTime());
		
		System.out.println(dt);
	} catch (ParseException e) {
		e.printStackTrace();
	}
}
}
