package com.java.servlets;

import java.sql.SQLException;

public class Dummy2 {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		try {
			System.out.println(dao.validateOtp("Harsh", 10454));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
