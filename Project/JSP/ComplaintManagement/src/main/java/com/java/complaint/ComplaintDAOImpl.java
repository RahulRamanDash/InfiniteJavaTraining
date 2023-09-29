package com.java.complaint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAOImpl implements ComplaintDAO{
	Connection con;
	PreparedStatement pst;

	public String incrimentStockID() throws ClassNotFoundException, SQLException{
		con = ConnectionHelper.getConnection();
		String cmd = "select max(ComplaintID) as sid from Complaint";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			String sid = rs.getString("sid");
			String numstr = sid.substring(1);
			int num = Integer.parseInt(numstr);
			num+=1;
			String stockid = String.format("C%03d", num);
			return stockid;
		}else {
			return "C001";
		}
	}

	public int generateResolveID() throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd ="select case when max(ResolveID) IS NULL THEN 1 else "
				+ " max(ResolveID)+1 end accno from Resolve";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno = rs.getInt("accno");
		
		return accno;
	}
	
	@Override
	public List<Complaint>showComplaintDao() throws ClassNotFoundException, SQLException {
		
		con = ConnectionHelper.getConnection();
		String cmd = "Select * from complaint where Status ='PENDING'";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		
		
		List<Complaint> comp = new ArrayList<Complaint>();
		Complaint complaint = null;
		while(rs.next()) {
			complaint = new Complaint();
			complaint.setComplaintID(rs.getString("complaintid"));;;
			complaint.setComplaintType(rs.getString("complainttype"));;
			complaint.setCDescription(rs.getString("CDescription"));;
			complaint.setComplaintDate(rs.getTimestamp("complaintDate"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("status"));
			comp.add(complaint);
			
			
		}
		return comp;

		
	}

	@Override
	public Complaint searchComplaintDao(String complaintid) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Select * from complaint where complaintID =?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, complaintid);
		ResultSet rs = pst.executeQuery();
		Complaint complaint = null;
		while(rs.next()) {
			complaint = new Complaint();
			complaint.setComplaintID(rs.getString("complaintid"));;;
			complaint.setComplaintType(rs.getString("complainttype"));;
			complaint.setCDescription(rs.getString("CDescription"));;
			complaint.setComplaintDate(rs.getTimestamp("complaintDate"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("status"));;
		}
		return complaint;
		
	}

	@Override
	public String addComplaintDao(Complaint complaint) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO Complaint (ComplaintID, ComplaintType, CDescription, Severity, Status) VALUES (?,?,?,?,?);";
		pst = con.prepareStatement(cmd);
		pst.setString(1, complaint.getComplaintID());
		pst.setString(2, complaint.getComplaintType());
		pst.setString(3, complaint.getCDescription());
		pst.setString(4, complaint.getSeverity());
		pst.setString(5, complaint.getStatus());		
		pst.executeUpdate();
		return "Complaint Registered...";
	}



	@Override
	public String resolveComplaintDao(Resolve resolve) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		Complaint complaintFound = searchComplaintDao(resolve.getComplaintID());
		if (complaintFound.getStatus().equals("PENDING")) {
			String cmd = "UPDATE Complaint SET Status='RESOLVED' where ComplaintID=?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, resolve.getComplaintID());
			pst.executeUpdate();
			
			int ResolveID = generateResolveID();
			cmd = "INSERT INTO Resolve (ResolveID, ComplaintID, ComplaintDate, ResolvedBy, Comments)\r\n"
					+ "VALUES (?,?,?,?,?);";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, ResolveID);
			pst.setString(2, complaintFound.getComplaintID());
			pst.setTimestamp(3, complaintFound.getComplaintDate());
			pst.setString(4, resolve.getResolvedBy());
			pst.setString(5, resolve.getComments());
			pst.executeUpdate();
			return "Complain Resolved";
		}else {
			return "Complaint Not Found";
		}
	}

	@Override
	public String complaintHistoryDao() {
		con = ConnectionHelper.getConnection();
		String cmd = "Select * from resolve";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Resolve> resolveList = new ArrayList<Resolve>();
		Resolve resolve = null;
		while(rs.next()) {
			resolve = new Resolve();
			resolve.setResolveID(rs.getString("ResolveID"));
			resolve.setComplaintID(rs.getString("ComplaintID"));
			resolve.setComplaintDate(rs.getString("ComplaintDate"));
			resolve.setResolveDate(rs.getTimestamp("ResolveDate"));
			Resolve.setSeverity(rs.getString("ResolvedBy"));
			Resolve.setStatus(rs.getString("Comments"));
			Resolve.add(resolve);
		}
		return comp;
	}
}