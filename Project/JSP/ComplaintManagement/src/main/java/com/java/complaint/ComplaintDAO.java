package com.java.complaint;

import java.sql.SQLException;
import java.util.List;

public interface ComplaintDAO {
	public List<Complaints> showComplaintsDao() throws ClassNotFoundException, SQLException;
	public String addComplaintDao();
	Complaints searchComplaints(int Complaint_ID) throws ClassNotFoundException, SQLException;
}