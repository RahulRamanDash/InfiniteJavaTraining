package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployUpdate {

	public static void main(String[] args) {
		int empno;
		double basic;
		String name, gender,dept,desig;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employ Number To Update Data ");
		empno = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Name ");
		name = sc.nextLine();
		System.out.println("Enter Gender (MALE/FEMALE)");
		gender = sc.nextLine();
		System.out.println("Enter Department ");
		dept = sc.nextLine();
		System.out.println("Enter Designation ");
		desig = sc.nextLine();
		System.out.println("Enter Basic ");
		basic = Double.parseDouble(sc.nextLine());
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/infinite_august23","root","root");
					//System.out.println("Connected...");
			String cmd = "update employ set name=?,gender=?,dept=?,desig=?,basic=? where empno=?";
			PreparedStatement pst = connection.prepareStatement(cmd);
			
			pst.setString(1, name);
			pst.setString(2, gender);
			pst.setString(3, dept);
			pst.setString(4, desig);
			pst.setDouble(5, basic);
			pst.setInt(6, empno);
			
			pst.executeUpdate();
			System.out.println("*** Record Updated ***");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
				

	}
}
