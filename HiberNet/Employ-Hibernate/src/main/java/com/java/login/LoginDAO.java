package com.java.login;

public interface LoginDAO {
	String addUser(Login login);
	Login authenticate(Login login);
}
