package com.java.BankWebsite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BankConnectionHelper {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("bank");
		String deiver = rb.getString("driver");
		String url = rb.getString("url");
		String user = rb.getString("user");
		String pass = rb.getString("pass");
		
		Connection connection = null;
		Class.forName(deiver);
		connection = DriverManager.getConnection(url,user,pass);
		
		return connection;
	}

}
