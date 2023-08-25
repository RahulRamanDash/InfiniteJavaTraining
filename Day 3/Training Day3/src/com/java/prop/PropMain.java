package com.java.prop;

public class PropMain {

	public static void main(String[] args) {
		Customer customer = new Customer(1, "Rahul");
		
		System.out.println("Customer Id : "+customer.getCutId());
		System.out.println("Customer Name : "+customer.getName());
		
	}

}
