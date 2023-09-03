package com.java.leaveproject;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface LeaveDAO {
	List<LeaveDetails> showLeaveDao();
	String addLeaveDao(LeaveDetails leavedata) throws ParseException;
	int incrimentLeaveID();
	String writeLeaveFileDao() throws IOException;
	String ReadLeaveFileDao() throws IOException, ClassNotFoundException;
	
}
