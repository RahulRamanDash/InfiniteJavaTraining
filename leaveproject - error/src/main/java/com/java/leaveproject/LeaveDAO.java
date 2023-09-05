package com.java.leaveproject;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface LeaveDAO {
	List<LeaveDetails> showLeaveDao();
	String addLeaveDao(LeaveDetails leavedata) throws ParseException;
	int incrimentLeaveID();
	String updateLeaveDao(LeaveDetails leaveUpdated);
	String writeLeaveFileDao() throws IOException;
	String ReadLeaveFileDao() throws IOException, ClassNotFoundException;
	LeaveDetails searchLeaveDao(int leaveid);
}
