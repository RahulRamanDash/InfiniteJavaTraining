package com.java.loginapp;

import java.sql.SQLException;

public interface LoginDAO {
	String createUser(Login login) throws ClassNotFoundException, SQLException;
	String checklogin(String username,String password) throws ClassNotFoundException, SQLException;
}
