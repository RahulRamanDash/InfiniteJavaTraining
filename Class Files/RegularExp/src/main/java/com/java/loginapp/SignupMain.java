package com.java.loginapp;

import java.sql.SQLException;
import java.util.Scanner;

public class SignupMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter UserName");
		String user = sc.next();
		System.out.println("Enter PassWord");
		String pass = sc.next();
		System.out.println("Enter RePassword");
		String repass = sc.next();
		
		if(pass.equals(repass)) {
			Login login = new Login();
			login.setUserName(user);
			login.setPassCode(pass);
			
			try {
				LoginDAO dao = new LoginDaoImpl();
				System.out.println(dao.createUser(login));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
	}
}
}