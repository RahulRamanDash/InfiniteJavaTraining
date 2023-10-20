package com.java.loginapp;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name :");
		String username = sc.next();
		System.out.println("Enter Password :");
		String password = sc.next();
		LoginDAO dao = new LoginDaoImpl();
		try {
			System.out.println(dao.checklogin(username, password));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
