package com.java.loginapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.regularexp.ConnectionHelper;

public class LoginDaoImpl implements LoginDAO{
	PreparedStatement pst;
	Connection connection;

	@Override
	public String createUser(Login login) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String pwd = EncryptPassword.getCode(login.getPassCode());
		String cmd = "Insert into login(userName,passCode) values (?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, login.getUserName());
		pst.setString(2, pwd);
		pst.executeUpdate();
		
		return "Account Created With Encrypted Password";
	}

	@Override
	public String checklogin(String username,String password) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String pwd = EncryptPassword.getCode(password);
		String cmd = "select count(*) as cnt from login where userName=? and passcode=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, username);
		pst.setString(2, pwd);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			int val = rs.getInt("cnt");
			System.out.println(val);
		}
		return "Login Success";
	}

}
