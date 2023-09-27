package com.java.inventoryproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	Connection connection;
	PreparedStatement pst;
	public String incrimentStockID() throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(stockid) as sid from stock";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			String sid = rs.getString("sid");
			String numstr = sid.substring(1);
			int num = Integer.parseInt(numstr);
			num+=1;
			String stockid = String.format("S%03d", num);
			return stockid;
		}else {
			return "S001";
		}
	}
	public static void main(String[] args) {
		Test test = new Test();
		//test.incrimentStockID();
		
	}

}
