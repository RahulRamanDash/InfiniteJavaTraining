package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployDelete {


	public static void main(String[] args) {
		int empno;
		double basic;
		String name, gender,dept,desig;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employ Number To Delete Data ");
		empno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/infinite_august23","root","root");
					//System.out.println("Connected...");
			String cmd = "delete from employ where empno=?";
			PreparedStatement pst = connection.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.executeUpdate();
			
			System.out.println("*** Record Deleated ***");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
				

	}
}
