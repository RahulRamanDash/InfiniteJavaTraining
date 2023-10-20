package com.java.lms;

import java.sql.Date;

public class Employee {

	private int EmpId;
	private String EmpName;
	private String EmpEmail;
	private String MobileNo;
	private Date DateOfJion;
	private int ManagerId;
	private int LeaveAvail;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, String empEmail, String mobileNo, Date dateOfJion, int managerId,
			int leaveAvail) {
		super();
		EmpId = empId;
		EmpName = empName;
		EmpEmail = empEmail;
		MobileNo = mobileNo;
		DateOfJion = dateOfJion;
		ManagerId = managerId;
		LeaveAvail = leaveAvail;
	}
	@Override
	public String toString() {
		return "Employ [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpEmail=" + EmpEmail + ", MobileNo=" + MobileNo
				+ ", DateOfJion=" + DateOfJion + ", ManagerId=" + ManagerId + ", LeaveAvail=" + LeaveAvail + "]";
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpEmail() {
		return EmpEmail;
	}
	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String string) {
		MobileNo = string;
	}
	public Date getDateOfJion() {
		return DateOfJion;
	}
	public void setDateOfJion(Date dateOfJion) {
		DateOfJion = dateOfJion;
	}
	public int getManagerId() {
		return ManagerId;
	}
	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}
	public int getLeaveAvail() {
		return LeaveAvail;
	}
	public void setLeaveAvail(int leaveAvail) {
		LeaveAvail = leaveAvail;
	} 
		
	
	
}
