package com.java.prop;

public class EmployMain {

	public static void main(String[] args) {
		Employ employ = new Employ();
		employ.setEmpId(1);
		employ.setEmpName("Rahul");
		employ.setBasic(12356.1);
		
		System.out.println(employ.getEmpId());
		System.out.println(employ.getEmpName());
		System.out.println(employ.getBasic());
		
		
	}

}
