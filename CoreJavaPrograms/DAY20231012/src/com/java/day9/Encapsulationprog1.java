package com.java.day9;

 class Encapsulationprog1 {
	 //by using acess modifier we can achive encapsulation
	// create variables with private access modifier
	private int empno;
	private double salary;
	private String name;
	
	//  getter and setters
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		// object to call getter and setter
		 Encapsulationprog1 x=new Encapsulationprog1();
		 // calling the setter using object
		 x.setEmpno(10);
		 // calling the getter using object
		 System.out.println(x.getEmpno());
	}
	
}
