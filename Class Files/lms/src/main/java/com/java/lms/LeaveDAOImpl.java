package com.java.lms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAOImpl implements LeaveDetailsDAO {

	Connection connection;
	PreparedStatement pst;
	
	public int dateDiff(Date startDate, Date endDate) {
		long ms = endDate.getTime() - startDate.getTime();
		int diff = (int)(ms/(1000 * 60 * 60 * 24));
		diff++;
		return diff;
	}
	
	@Override
	public String applyLeaveDao(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException {
		System.out.println(leaveDetails);
		connection = ConnectionHelper.getConnection();
		int diff = dateDiff(leaveDetails.getLeaveStartDate(), leaveDetails.getLeaveEndDate());
		leaveDetails.setNoOfDays(diff);
		String cmd = "Insert into LeaveDetails(EmpId,LeaveStartDate,LeaveEndDate,"
				+ "noOfDays,leaveType,leaveReason) values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveDetails.getEmpId());
		pst.setDate(2, leaveDetails.getLeaveStartDate());
		pst.setDate(3, leaveDetails.getLeaveEndDate());
		pst.setInt(4, leaveDetails.getNoOfDays());
		pst.setString(5, leaveDetails.getLeaveType().toString());
		pst.setString(6, leaveDetails.getLeaveReason());
		pst.executeUpdate();
		cmd = "Update Employee set LeaveAvail = LeaveAvail - ? Where EmpId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, diff);
		pst.setInt(2, leaveDetails.getEmpId());
		pst.executeUpdate();
		return "Leave Applied...";
	}

	@Override
	public List<LeaveDetails> showLeaveDao(int empid) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from leavedetails where empid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empid);
		ResultSet rs = pst.executeQuery();
		List<LeaveDetails> leaveList = new ArrayList<LeaveDetails>();
		LeaveDetails leaveDetails = null;
		while(rs.next()) {
			leaveDetails = new LeaveDetails();
			leaveDetails.setEmpId(rs.getInt("empid"));
			leaveDetails.setLeaveStartDate(rs.getDate("LeaveStartDate"));
			leaveDetails.setLeaveEndDate(rs.getDate("LeaveEndDate"));
			leaveDetails.setNoOfDays(rs.getInt("noOfDays"));
			leaveDetails.setLeaveType(LeaveType.valueOf(rs.getString("leaveType")));
			leaveDetails.setLeaveReason(rs.getString("leaveReason"));
			
			leaveList.add(leaveDetails);
			
		}
		return leaveList;
	}


}



