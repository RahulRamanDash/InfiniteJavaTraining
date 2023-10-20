package com.java.servlets;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

public class addUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer customer  =new Customer();
		System.out.println("First Name:");
		customer.setFirstName(sc.next());
		System.out.println("Last Name: ");
		customer.setLastName(sc.next());
		System.out.println("Username: ");
		customer.setUserName(sc.next());
		System.out.println("Password: ");
		customer.setPassword(sc.next());
		System.out.println("Email: ");
		customer.setEmail(sc.next());
		
		
		CustomerDAO dao = new CustomerDAOImpl();
		try {
			System.out.println(dao.addCustomer(customer));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
