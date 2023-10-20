package com.java.lms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class LeaveDetailsDAOImpl implements LeaveDetailsDAO{
	Connection connection;
	PreparedStatement pst;
	LeaveDetails leavedetails;

	
	
	
	public int datediff(Date startDate,Date endDate) {
		long ms = endDate.getTime() - startDate.getTime();
		int diff = (int)(ms/(1000* 60*60*24));
		diff++;
		return diff;
	}
	@Override
	public List<LeaveDetails> showLeaveDao(int empno) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from LeaveDetails";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<LeaveDetails> leaveList = new ArrayList<LeaveDetails>();
		LeaveDetails leave = null;
		while(rs.next()) {
			leave = new LeaveDetails();
			leave.setLeaveId(rs.getInt("LeaveId"));
			leave.setEmpId(rs.getInt("empid"));
			leave.setLeaveStartDate(rs.getDate("LeaveStartDate"));
			leave.setLeaveEndDate(rs.getDate("LeaveEndDate"));
			leave.setNoOfDays(rs.getInt("noOfDays"));
			leave.setLeaveType(LeaveType.valueOf("leaveType"));
			leave.setLeaveStatus(LeaveStatus.valueOf("leaveStatus"));
			leave.setLeaveReason(rs.getString("leaveReason"));
			leave.setManagerComments(rs.getString("ManagerComments"));
			leave.setAppliedOn(rs.getDate("appliedOn"));
			leaveList.add(leave);
		}
		
		return leaveList;
	}
	


	@Override
	public String applyLeaveDao(LeaveDetails leavedetails) throws ClassNotFoundException, SQLException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Get yesterday's date
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        java.util.Date yesterday = cal.getTime();

       // Format yesterday's date in the same format
       String startDateStr = sdf.format(leavedetails.getLeaveStartDate());
       String EndDateStr = sdf.format(leavedetails.getLeaveEndDate());
       String yesterdayStr = sdf.format(yesterday);
       
       
       Employee employee = new EmployDAOImpl().searchEmployeeDao(leavedetails.getEmpId());
       int leaveAvail = employee.getLeaveAvail();
  
      
       if (startDateStr.equals(yesterdayStr)) {
    	   return "Start Date Can not be Yester days date...\r\n";
       }
       else if(EndDateStr.equals(yesterdayStr)) {
    	   return " End Date Can not be Yester days date...\r\n";
       }
       else if(leavedetails.getLeaveEndDate().before(leavedetails.getLeaveStartDate())) {
    	   return "Start Date Must be after todays date...\r\n";
       }
      
       else if(leavedetails.getNoOfDays() >= leaveAvail) {
       		return "Insufficient Leave Balance...";
       }
      
      // else if() {
    	   
       //}
       else {
		
		connection = ConnectionHelper.getConnection();
		int diff = datediff(leavedetails.getLeaveStartDate(), leavedetails.getLeaveEndDate());
		leavedetails.setNoOfDays(diff);
		String cmd = "insert into LeaveDetails(EmpId,LeaveStartDate,LeaveEndDate,noOfDays,leaveType,leaveReason) values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		
		pst.setInt(1, leavedetails.getEmpId());
		pst.setDate(2, leavedetails.getLeaveStartDate());
		pst.setDate(3, leavedetails.getLeaveEndDate());
		pst.setInt(4, leavedetails.getNoOfDays());
		pst.setString(5, leavedetails.getLeaveType().toString());
		pst.setString(6, leavedetails.getLeaveReason());
		pst.executeUpdate();
		cmd = "Update Employee set LeaveAvail = LeaveAvail - ? Where EmpId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, diff);
		pst.setInt(2, leavedetails.getEmpId());
		pst.executeUpdate();
		return "Leave Applied";
       }
		
	}


}
