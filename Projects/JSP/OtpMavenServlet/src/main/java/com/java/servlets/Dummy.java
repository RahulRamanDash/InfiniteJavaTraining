package com.java.servlets;

import java.sql.SQLException;

public class Dummy {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setFirstName("Harsh");
		customer.setLastName("Kumar");
		customer.setUserName("Harsh");
		customer.setPassword("Harsh");
		customer.setEmail("harshkumar1882000@gmail.com");
		customer.setPhoneNo("848482234");
		CustomerDAO dao = new CustomerDAOImpl();
		try {
			System.out.println(dao.addCustomer(customer));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
