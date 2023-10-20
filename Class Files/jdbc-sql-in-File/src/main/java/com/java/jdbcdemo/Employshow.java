package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Employshow {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/infinite_august23","root","root");
			System.out.println("Connected...");
			
			String cmd = "select * from employ";
			PreparedStatement pst = connection.prepareStatement(cmd);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				System.out.println("Employ No is "+rs.getInt("empno"));
				System.out.println("Employ Name "+rs.getString("name"));
				System.out.println("Gender "+rs.getString("gender"));
				System.out.println("Department "+rs.getString("dept"));
				System.out.println("Designation "+rs.getString("desig"));
				System.out.println("Basic "+rs.getInt("basic"));
				System.out.println("-----------------------------------");

			}
			
			
			
			System.out.println("Done");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
