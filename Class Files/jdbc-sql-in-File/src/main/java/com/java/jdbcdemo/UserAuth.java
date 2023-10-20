package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserAuth {

	public static void main(String[] args) {
		String user,pass;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name : ");
		user = sc.next();
		System.out.println("Enter Password : ");
		pass = sc.next();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/infinite_august23","root","root");
					//System.out.println("Connected...");
					
					String cmd = "select count(*) cnt from login where username=?" +"And passcode=?";
					PreparedStatement pst = connection.prepareStatement(cmd);
					pst.setString(1, user);
					pst.setString(2, pass);
					ResultSet rs =  pst.executeQuery();
					rs.next();
					int count = rs.getInt("cnt");
					if(count==1) {
						System.out.println("Correct Cred...");
					}
					else {
						System.out.println("Invalid Cred...");
					}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
