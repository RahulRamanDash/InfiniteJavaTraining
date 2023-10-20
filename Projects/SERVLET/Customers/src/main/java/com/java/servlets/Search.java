package com.java.servlets;

 

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

 

public class Search {

 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		String UserName = sc.next();

		CustomerDAO dao = new CustomerDAOImpl();
		try {
			System.out.println(dao.searchByUserName(UserName));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}