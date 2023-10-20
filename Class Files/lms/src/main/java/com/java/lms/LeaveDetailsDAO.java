package com.java.lms;

import java.sql.SQLException;
import java.util.List;

public interface LeaveDetailsDAO {

	//List<LeaveDetails> showLeaveDao() throws ClassNotFoundException, SQLException;
	String applyLeaveDao(LeaveDetails leavedetails) throws ClassNotFoundException, SQLException;
	//LeaveDetails searchLeaveeDao(int empId) throws ClassNotFoundException, SQLException;
	List<LeaveDetails> showLeaveDao(int empid) throws SQLException, ClassNotFoundException;
}
