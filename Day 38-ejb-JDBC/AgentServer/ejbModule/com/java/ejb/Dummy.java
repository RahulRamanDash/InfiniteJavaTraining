package com.java.ejb;

import java.sql.SQLException;

public class Dummy {

	public static void main(String[] args) {
		try {
			System.out.println(new AgentBean().showAgent());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}