package com.java.complaint;

import java.sql.SQLException;
import java.util.List;

public interface ComplaintDAO {

	List<Complaint> showComplaintDao() throws ClassNotFoundException, SQLException;
	Complaint searchComplaintDao(String ComplaintID) throws ClassNotFoundException,SQLException;
	String addComplaintDao(Complaint complaint) throws ClassNotFoundException,SQLException;
	String resolveComplaintDao(Resolve resolve) throws ClassNotFoundException, SQLException;
	List<Resolve> complaintHistoryDao() throws ClassNotFoundException, SQLException;
}