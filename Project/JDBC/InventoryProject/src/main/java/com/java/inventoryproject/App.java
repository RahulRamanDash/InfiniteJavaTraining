package com.java.inventoryproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {



  public static void main(String[] args) throws ClassNotFoundException, SQLException {
//	  	String stockid ="S001";
//		String numstr = stockid.substring(1);
//		int num = Integer.parseInt(numstr);
//		num+=1;
//		stockid = String.format("S%03d", num);
//		System.out.println(stockid);
//		Connection connection;
//		PreparedStatement pst;
//		
//		connection = ConnectionHelper.getConnection();
//		String cmd = "select max(stockid) as sid from stock";
//		pst = connection.prepareStatement(cmd);
//		ResultSet rs = pst.executeQuery();
//		if(rs.next()) {
//			String sid = rs.getString("sid");
//			String numstr = sid.substring(1);
//			int num = Integer.parseInt(numstr);
//			num+=1;
//			String stockid = String.format("S%03d", num);
//			System.out.println(stockid);
//  }

	  
	  int a = 5;
	  double b =5;
	  
	  double c = a*b;
	  System.out.println(c);
  }
  }
