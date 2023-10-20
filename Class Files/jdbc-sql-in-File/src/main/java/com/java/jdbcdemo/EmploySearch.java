package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearch {
	public static void main(String[] args) {
	int empno;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Employ Number : ");
	empno = sc.nextInt();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection =
		DriverManager.getConnection("jdbc:mysql://localhost:3306/infinite_august23","root","root");
		//System.out.println("Connected...");
		
		String cmd = "select * from employ where empno=?";
		PreparedStatement pst = connection.prepareStatement(cmd);
		
		pst.setInt(1, empno);
		ResultSet rs =  pst.executeQuery();
		if(rs.next()) {
			System.out.println("Employ No is "+rs.getInt("empno"));
			System.out.println("Employ Name "+rs.getString("name"));
			System.out.println("Gender "+rs.getString("gender"));
			System.out.println("Department "+rs.getString("dept"));
			System.out.println("Designation "+rs.getString("desig"));
			System.out.println("Basic "+rs.getInt("basic"));
			System.out.println("-----------------------------------");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}
}
