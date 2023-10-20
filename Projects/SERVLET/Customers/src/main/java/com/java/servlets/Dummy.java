package com.java.servlets;

import java.sql.SQLException;

public class Dummy {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setFirstName("Jitendra");
		customer.setLastName("Saho");
		customer.setUserName("Jitu");
		customer.setPassword("Jitu");
		customer.setEmail("ayushsamanta1475@gmail.com");
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
