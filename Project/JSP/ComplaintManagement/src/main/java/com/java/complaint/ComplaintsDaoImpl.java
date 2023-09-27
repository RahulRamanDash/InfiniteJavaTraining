package com.java.complaint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintsDaoImpl implements ComplaintDAO{
	Connection connection;
	PreparedStatement pst;
	
	
	public int daysDiff(Date startDate) throws ClassNotFoundException, SQLException{
		Date currentDate = new Date(); // Get the current date
	    long ms = currentDate.getTime() - startDate.getTime();
	    int diff = (int) (ms / (1000 * 60 * 60 * 24));
	    diff++;
	    return diff;
	}
	
	@Override
	public List<Complaints> showComplaintsDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * From complaints";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Complaints> complaints = new ArrayList<Complaints>();
		Complaints complaint = null;
		while(rs.next()) {
			complaint = new Complaints();
			complaint.setComplaint_ID(rs.getInt("Complaint_ID"));
			complaint.setComplaint(rs.getString("Complaint"));
			complaint.setStatus(rs.getString("status"));
			complaint.setRegdate(rs.getDate("regdate"));
			complaints.add(complaint);
		}
		return complaints;
	}

	@Override
	public String addComplaintDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complaints searchComplaints(int ComplaintID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * From complaints where Complaint_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, ComplaintID);
		ResultSet rs = pst.executeQuery();
		Complaints complaint = null;
		while(rs.next()) {
			complaint = new Complaints();
			complaint.setComplaint_ID(rs.getInt("Complaint_ID"));
			complaint.setComplaint(rs.getString("Complaint"));
			complaint.setStatus(rs.getString("status"));
			complaint.setRegdate(rs.getDate("regdate"));
		}
		return complaint;
	}
	
}
