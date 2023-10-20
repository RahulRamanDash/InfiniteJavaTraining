package com.java.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class ComplaintDAOImpl implements ComplaintDAO{
	Connection con;
	PreparedStatement pst;

	@Override
	public List<Complaint>showComplaintDAO() throws ClassNotFoundException, SQLException {
		
		con = ConnectionHelper.getConnection();
		String cmd = "Select * from complaint";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		
		
		List<Complaint> comp = new ArrayList<Complaint>();
		Complaint complaint = null;
		
		while(rs.next()) {
			complaint = new Complaint();
			complaint.setComplaintid(rs.getString("complaintid"));
			complaint.setComplaintType(rs.getString("ComplaintType"));
			complaint.setCDescription(rs.getString("CDescription"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("Status"));
			complaint.setComplaintDate(rs.getTimestamp("complaintDate"));
			
			comp.add(complaint);
			
			
		}
		return comp;

		
	}

	

	@Override
	public Complaint searchComplaintDAO(String complaintid) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Select * from complaint where complaintID =?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, complaintid);
		ResultSet rs = pst.executeQuery();
		Complaint complaint = null;
		while(rs.next()) {
			
			complaint = new Complaint();
			complaint.setComplaintid(rs.getString("complaintid"));
			complaint.setComplaintType(rs.getString("ComplaintType"));
			complaint.setCDescription(rs.getString("CDescription"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("Status"));
			complaint.setComplaintDate(rs.getTimestamp("complaintDate"));
			
		}
		return complaint;
		
	}

	@Override
	public String addComplaintDAO(Complaint complaint) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Insert into complaint(complaintid,ComplaintType,CDescription,Severity,Status)"
				+ "values(?,?,?,?,?)";
		pst= con.prepareStatement(cmd);
		pst.setString(1, complaint.getComplaintid());
		pst.setString(2, complaint.getComplaintType());
		pst.setString(3, complaint.getCDescription());
		pst.setString(4, complaint.getSeverity());
		pst.setString(5, complaint.getStatus());
	
		pst.executeUpdate();
		
		return "complaint was added...";
	}
	
	
	
	

}
