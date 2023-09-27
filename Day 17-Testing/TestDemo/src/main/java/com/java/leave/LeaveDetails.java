package com.java.leave;

import java.util.Date;

public class LeaveDetails {

	private int leaveId;
	private int empId;
	private String empName;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private LeaveStatus leaveStatus;
	private LeaveType leaveType;
	private String leaveReason;
	private String managerComments;
	private Date appliedOn;
	public LeaveDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaveDetails(int leaveId, int empId, String empName, Date leaveStartDate, Date leaveEndDate,
			LeaveStatus leaveStatus, LeaveType leaveType, String leaveReason, String managerComments, Date appliedOn) {
		super();
		this.leaveId = leaveId;
		this.empId = empId;
		this.empName = empName;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.leaveStatus = leaveStatus;
		this.leaveType = leaveType;
		this.leaveReason = leaveReason;
		this.managerComments = managerComments;
		this.appliedOn = appliedOn;
	}
	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", empId=" + empId + ", empName=" + empName + ", leaveStartDate="
				+ leaveStartDate + ", leaveEndDate=" + leaveEndDate + ", leaveStatus=" + leaveStatus + ", leaveType="
				+ leaveType + ", leaveReason=" + leaveReason + ", managerComments=" + managerComments + ", appliedOn="
				+ appliedOn + "]";
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getManagerComments() {
		return managerComments;
	}
	public void setManagerComments(String managerComments) {
		this.managerComments = managerComments;
	}
	public Date getAppliedOn() {
		return appliedOn;
	}
	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
	}
	
}