package com.java.prop;

public class Customer {

	private int cutId;
	private String name;
	
	
	public Customer(int cutId, String name) {
		super();
		this.cutId = cutId;
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Customer [cutId=" + cutId + ", name=" + name + "]";
	}
	
	
	public int getCutId() {
		return cutId;
	}

	
	public String getName() {
		return name;
	}
}
