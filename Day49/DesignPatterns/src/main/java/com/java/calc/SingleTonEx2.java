package com.java.calc;

public class SingleTonEx2 {
	
	private static ConnectionString cs;
	static {
		cs = ConnectionString.getInstance();
	}
	
	public static void main(String[] args) {
		System.out.println(cs.getCredentials("MySql"));

	
	}
}
