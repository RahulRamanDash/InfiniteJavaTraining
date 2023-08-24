package com.java.abst;

public abstract class Employ {
	int impid;
	String name;
	double basic;
	
	
	public Employ(int impid, String name, double basic) {
		super();
		this.impid = impid;
		this.name = name;
		this.basic = basic;
	}


	@Override
	public String toString() {
		return "Employ [impid=" + impid + ", name=" + name + ", basic=" + basic
				+ "]";
	}

}
