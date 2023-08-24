package com.java.cons;

public class Employ {
	int empno;
	String name;
	double besic;
	
	public Employ(int empno, String name, double besic) {
		super();
		this.empno = empno;
		this.name = name;
		this.besic = besic;
	}

	@Override
	public String toString() {
		return "Employ [empno=" + empno + ", name=" + name + ", besic=" + besic
				+ "]";
	}

	public Employ() {
		super();
	}

}
