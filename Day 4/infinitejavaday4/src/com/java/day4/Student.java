package com.java.day4;

public class Student {
	private int studentId;
	private String name;
	private String City;
	private double cgp;
	public Student(int studentId, String name, String city, double cgp) {
		super();
		this.studentId = studentId;
		this.name = name;
		City = city;
		this.cgp = cgp;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", City="
				+ City + ", cgp=" + cgp + "]";
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public double getCgp() {
		return cgp;
	}
	public void setCgp(double cgp) {
		this.cgp = cgp;
	}

}
