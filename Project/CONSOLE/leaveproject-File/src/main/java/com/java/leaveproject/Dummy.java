package com.java.leaveproject;

public class Dummy {

	private int empno;
	private String name;
	private String city;
	private double basic;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public Dummy(int empno, String name, String city, double basic) {
		super();
		this.empno = empno;
		this.name = name;
		this.city = city;
		this.basic = basic;
	}
	public Dummy() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dummy [empno=" + empno + ", name=" + name + ", city=" + city + ", basic=" + basic + "]";
	}
	
	
}
