package com.java.calc;

public class ConnectionString {
	private ConnectionString() {}
	private static ConnectionString connectionString;
	
	public static ConnectionString getInstance() {
		if(connectionString==null) {			
			connectionString = new ConnectionString();
		}
		return connectionString;
	}
	
	public String getCredentials(String db) {
		String result;
		switch (db) {
		case "MySql":
			result="root/root";
			break;
		case "Oracle":
			result="scott/tiger";
			break;
		case "SqlServer":
			result="sa/Password123";
			break;
		}
		return result;
	}
}
