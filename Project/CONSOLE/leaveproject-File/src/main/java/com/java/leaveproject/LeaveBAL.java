package com.java.leaveproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LeaveBAL {

	static StringBuilder sb;
	static LeaveDAO dao;
	static {
		dao = new LeaveDaoimpl();
		sb = new StringBuilder();
	}
	public List<LeaveDetails> showLeaveBal() {
		return dao.showLeaveDao();
	}
	
	
	public String addLeaveBal(LeaveDetails leavedata) throws LeaveException, ParseException {
		if (validateLeave(leavedata)==true) {
			return dao.addLeaveDao(leavedata);
		}
		throw new LeaveException(sb.toString());
	}

	public LeaveDetails searchLeaveBal(int leaveid){
		return dao.searchLeaveDao(leaveid);
		}
	public String ApproveDenyLeaveBal(int leaveid, String mgcomm, String leavestatus) {
		return dao.ApproveDenyLeaveDao(leaveid,mgcomm,leavestatus);
	}
	

	public String ReadLeaveFileBal() throws IOException, ClassNotFoundException{
		return dao.ReadLeaveFileDao();
	}
	public String writeLeaveFileBal() throws FileNotFoundException, IOException{
		return dao.writeLeaveFileDao();
	}
	
	
	
	//validate leave application
	public boolean validateLeave(LeaveDetails leavedetails){
		boolean flag = true;
		 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            // Parse the input date string to a Date object
		 
	            // Get yesterday's date
	            Calendar cal = Calendar.getInstance();
	            cal.add(Calendar.DATE, -1);
	            Date yesterday = cal.getTime();

	            // Format yesterday's date in the same format
	            String startDateStr = sdf.format(leavedetails.getLeaveStartDate());
	            String EndDateStr = sdf.format(leavedetails.getLeaveEndDate());
	            String yesterdayStr = sdf.format(yesterday);
	            // Compare the input date with yesterday's date
	            if (startDateStr.equals(yesterdayStr) || EndDateStr.equals(yesterdayStr)) {
	            	flag = false;
	            	sb.append("Start Date and End Date Can not be Yester days date...\r\n");
	            }
	            if(leavedetails.getLeaveStartDate().before(yesterday)) {
	            	flag = false;
	            	sb.append("Start Date Must be after todays date...\r\n");
	            }

	            if(leavedetails.getNoOfDays() >= 10) {
	            	flag=false;
	            	sb.append("No of Leave days can not ba more then 10 days...\r\n");
	            }
	            if(leavedetails.getLeaveEndDate().before(leavedetails.getLeaveStartDate())) {
	            	flag=false;
	            	sb.append("Leave End date must be grater then Start date...\r\n");
	            }
	            
		return flag;
		
	}




	





}
