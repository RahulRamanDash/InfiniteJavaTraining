package com.java.infinite;

import java.sql.SQLException;
import java.util.List;

public interface LeaveDetailsDAO {

	List<LeaveDetails> showLeaveDao(int empno) throws ClassNotFoundException, SQLException;
	List<LeaveDetails> showPendingLeaveDao(int empno) throws ClassNotFoundException, SQLException;
	String applyLeave(LeaveDetails leavedetails) throws ClassNotFoundException, SQLException;
	LeaveDetails searchLeaveDao(int leaveId) throws ClassNotFoundException, SQLException;
	String ApproveDeny(int leaveid,int managerid, String status,String mgcmt) throws ClassNotFoundException, SQLException;
}
