package com.java.complaint;

import java.sql.Date;

public class Complaints {

	private int Complaint_ID;
	private String complaint;
	private String status;
	private Date regdate;
	public Complaints() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complaints(int complaint_ID, String complaint, String status, Date regdate) {
		super();
		Complaint_ID = complaint_ID;
		this.complaint = complaint;
		this.status = status;
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Complaints [Complaint_ID=" + Complaint_ID + ", complaint=" + complaint + ", status=" + status
				+ ", regdate=" + regdate + "]";
	}
	public int getComplaint_ID() {
		return Complaint_ID;
	}
	public void setComplaint_ID(int complaint_ID) {
		Complaint_ID = complaint_ID;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
