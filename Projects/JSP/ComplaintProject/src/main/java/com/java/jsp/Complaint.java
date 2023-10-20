package com.java.jsp;

import java.sql.Timestamp;

public class Complaint {
	
	private String complaintid;	
	private String ComplaintType;
	private String CDescription;
	private String Severity;
	private	String status;
	private Timestamp complaintDate;
	public String getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(String complaintid) {
		this.complaintid = complaintid;
	}
	public String getComplaintType() {
		return ComplaintType;
	}
	public void setComplaintType(String complaintType) {
		ComplaintType = complaintType;
	}
	public String getCDescription() {
		return CDescription;
	}
	public void setCDescription(String cDescription) {
		CDescription = cDescription;
	}
	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Timestamp complaintDate) {
		this.complaintDate = complaintDate;
	}
	@Override
	public String toString() {
		return "Complaint [complaintid=" + complaintid + ", ComplaintType=" + ComplaintType + ", CDescription="
				+ CDescription + ", Severity=" + Severity + ", status=" + status + ", complaintDate=" + complaintDate
				+ "]";
	}
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complaint(String complaintid, String complaintType, String cDescription, String severity, String status,
			Timestamp complaintDate) {
		super();
		this.complaintid = complaintid;
		ComplaintType = complaintType;
		CDescription = cDescription;
		Severity = severity;
		this.status = status;
		this.complaintDate = complaintDate;
	}
	
	
	
	
}