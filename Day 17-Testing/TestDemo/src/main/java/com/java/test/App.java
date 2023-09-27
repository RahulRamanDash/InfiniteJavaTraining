package com.java.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.java.leave.LeaveDetails;
import com.java.leave.LeaveStatus;
import com.java.leave.LeaveType;

public class App {

  public static void main(String[] args) {
	  Employ emp = new Employ(1,"Rahul",Gender.MALE,"Java","ASE",99424);
    System.out.println(emp);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date lsd;
	try {
		lsd = sdf.parse("2023-10-10");
		Date led = sdf.parse("2023-10-10");
		Date aon = sdf.parse("2023-09-13");
		//Date cdate = new Date();
		Date cdate = sdf.parse("2023-09-14");
		LeaveDetails leavedetails1 = new LeaveDetails(1,1000,"Rahul",lsd,led,LeaveStatus.PENDING,LeaveType.EL,"sadi","welcome",cdate);
		System.out.println(leavedetails1);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }

}
