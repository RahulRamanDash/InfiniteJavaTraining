package com.java.complaint;

import java.sql.Date;
import java.sql.Timestamp;

public class Complaint {

	private String ComplaintID;
	private String ComplaintType;
	private String CDescription;
	private Timestamp ComplaintDate;
	private String Severity;
	private String Status;
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complaint(String complaintID, String complaintType, String cDescription, Timestamp complaintDate, String severity,
			String status) {
		super();
		ComplaintID = complaintID;
		ComplaintType = complaintType;
		CDescription = cDescription;
		ComplaintDate = complaintDate;
		Severity = severity;
		Status = status;
	}
	
	@Override
	public String toString() {
		return "Complaint [ComplaintID=" + ComplaintID + ", ComplaintType=" + ComplaintType + ", CDescription="
				+ CDescription + ", ComplaintDate=" + ComplaintDate + ", Severity=" + Severity + ", Status=" + Status
				+ "]";
	}
	
	public String getComplaintID() {
		return ComplaintID;
	}
	public void setComplaintID(String complaintID) {
		ComplaintID = complaintID;
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
	public Timestamp getComplaintDate() {
		return ComplaintDate;
	}
	public void setComplaintDate(Timestamp timestamp) {
		ComplaintDate = timestamp;
	}
	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
