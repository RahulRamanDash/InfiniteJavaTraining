package com.java.ejb;

import java.io.Serializable;

public class DoctorMaster implements Serializable{
	private String drId;
	private String drName;
	private String dept;
	public DoctorMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorMaster(String drId, String drName, String dept) {
		super();
		this.drId = drId;
		this.drName = drName;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "DoctorMaster [drId=" + drId + ", drName=" + drName + ", dept=" + dept + "]";
	}
	public String getDrId() {
		return drId;
	}
	public void setDrId(String drId) {
		this.drId = drId;
	}
	public String getDrName() {
		return drName;
	}
	public void setDrName(String drName) {
		this.drName = drName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
