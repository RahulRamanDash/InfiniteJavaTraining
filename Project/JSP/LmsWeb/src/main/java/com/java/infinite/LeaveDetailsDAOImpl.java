package com.java.infinite;

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
		String cmd = "select * from LeaveDetails where empid=? order by leaveid desc";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		Employee employ = new Employee();
		List<LeaveDetails> leaveList = new ArrayList<LeaveDetails>();
		LeaveDetails leave = null;
		while(rs.next()) {
			leave = new LeaveDetails();
			leave.setLeaveId(rs.getInt("LeaveId"));
			leave.setEmpId(rs.getInt("empid"));
			leave.setLeaveStartDate(rs.getDate("LeaveStartDate"));
			leave.setLeaveEndDate(rs.getDate("LeaveEndDate"));
			leave.setNoOfDays(rs.getInt("noOfDays"));
			leave.setLeaveType(LeaveType.valueOf(rs.getString("leaveType")));
			leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("leaveStatus")));
			leave.setLeaveReason(rs.getString("leaveReason"));
			leave.setManagerComments(rs.getString("ManagerComments"));
			leave.setAppliedOn(rs.getDate("appliedOn"));
			leaveList.add(leave);
		}
		
		return leaveList;
	}
	
	@Override
	public LeaveDetails searchLeaveDao(int leaveid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from LeaveDetails where LeaveId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveid);
		ResultSet rs = pst.executeQuery();
		LeaveDetails leave = null;
		while(rs.next()) {
			leave = new LeaveDetails();
			leave.setLeaveId(rs.getInt("LeaveId"));
			leave.setEmpId(rs.getInt("empid"));
			leave.setLeaveStartDate(rs.getDate("LeaveStartDate"));
			leave.setLeaveEndDate(rs.getDate("LeaveEndDate"));
			leave.setNoOfDays(rs.getInt("noOfDays"));
			leave.setLeaveType(LeaveType.valueOf(rs.getString("leaveType")));
			leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("leaveStatus")));
			leave.setLeaveReason(rs.getString("leaveReason"));
			leave.setManagerComments(rs.getString("ManagerComments"));
			leave.setAppliedOn(rs.getDate("appliedOn"));
		}
		
		return leave;
	}
	

	@Override
	public String applyLeave(LeaveDetails leavedetails) throws ClassNotFoundException, SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Parse the input date string to a Date object
 
        // Get yesterday's date
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        java.util.Date yesterday = cal.getTime();

        // Format yesterday's date in the same format
        String startDateStr = sdf.format(leavedetails.getLeaveStartDate());
        String EndDateStr = sdf.format(leavedetails.getLeaveEndDate());
        String yesterdayStr = sdf.format(yesterday);
        
       Employee employee = new EmployeeDAOImpl().searchEmployeeDao(leavedetails.getEmpId());
       int leaveAvail = employee.getLeaveAvail();
       
       
      
       if (startDateStr.equals(yesterdayStr)) {
    	   		return "Start Date Can not be yesterday's date...\r\n";
       }
       else if(EndDateStr.equals(yesterdayStr)) {
    	   		return " End Date Can not be yesterday's date...\r\n";
       }
       else if(leavedetails.getLeaveStartDate().before(yesterday)) {
    	   		return "Start Date Must be after yesterday's date...\r\n";
       }
       else if(leavedetails.getLeaveEndDate().before(yesterday)) {
	   		return "End Date Must be after yesterday's date...\r\n";
       }
      
       else if(leavedetails.getNoOfDays() >= leaveAvail) {
       		return "Insufficient Leave Balance...";
       }
//       else if( ){
//    	   
//       }
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
	@Override
	public String ApproveDeny(int leaveid, int managerid, String status, String mgcmt) throws ClassNotFoundException, SQLException {
		LeaveDetails leaveFound = searchLeaveDao(leaveid);
		int empid = leaveFound.getEmpId();
		System.out.println(empid);
		EmployeeDAO dao = new EmployeeDAOImpl();
		System.out.println(managerid);
		Employee employ = dao.searchEmployeeDao(empid);
		System.out.println(employ);
		int mgrId = employ.getManagerId();
		System.out.println(mgrId);
		LeaveDetails newleave = new LeaveDetails();
		
		if(managerid==mgrId) {
			if("YES".equals(status)) {
				newleave.setLeaveStatus(LeaveStatus.valueOf("ACCEPTED"));
			}
			else if("NO".equals(status)) {
				newleave.setLeaveStatus(LeaveStatus.valueOf("REJECTED"));
			}
			else {
				return "Enter a Valid Option...";
			}
			connection = ConnectionHelper.getConnection();
			String cmd = "update leavedetails set leaveStatus=?,ManagerComments=? where leaveid=?";
			pst = connection.prepareStatement(cmd);	
			pst.setString(1, newleave.getLeaveStatus().toString());
			pst.setString(2, mgcmt);
			pst.setInt(3, leaveid);
			pst.executeUpdate();
			if(status.equals("NO")) {
				int diff = datediff(leaveFound.getLeaveStartDate(), leaveFound.getLeaveEndDate());
				cmd = "Update Employee set LeaveAvail = LeaveAvail + ? Where EmpId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, diff);
				pst.setInt(2, leaveFound.getEmpId());
				pst.executeUpdate();
			}
			return "Leave Review Compleated...";
		}
		else {
			return "Not Authorized";
		}
		
	}
	@Override
	public List<LeaveDetails> showPendingLeaveDao(int empno) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from LeaveDetails where empid in(select EmpId from employee where ManagerId =?) and  leaveStatus='PENDING';";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		Employee employ = new Employee();
		List<LeaveDetails> leaveList = new ArrayList<LeaveDetails>();
		LeaveDetails leave = null;
		while(rs.next()) {
			leave = new LeaveDetails();
			leave.setLeaveId(rs.getInt("LeaveId"));
			leave.setEmpId(rs.getInt("empid"));
			leave.setLeaveStartDate(rs.getDate("LeaveStartDate"));
			leave.setLeaveEndDate(rs.getDate("LeaveEndDate"));
			leave.setNoOfDays(rs.getInt("noOfDays"));
			leave.setLeaveType(LeaveType.valueOf(rs.getString("leaveType")));
			leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("leaveStatus")));
			leave.setLeaveReason(rs.getString("leaveReason"));
			leave.setManagerComments(rs.getString("ManagerComments"));
			leave.setAppliedOn(rs.getDate("appliedOn"));
			leaveList.add(leave);
		}
		
		return leaveList;
	}


}
