package com.java.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class UserAuth {
	
	public static void main(String[] args) {
		
	
	Map userData = new Hashtable();
	userData.put("Rahul","password");
	userData.put("Rohan", "password");
	userData.put("Ayush", "password");
	userData.put("Rajesh", "password");
	userData.put("Abhishak", "password");
	
	String user, pass;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter UserName...");
	user = sc.next();
	System.out.println("Enter Password...");
	pass = sc.next();
	
	//String reasult = (String)userData.getOrDefault(user,"User Not Found..");
	//System.out.println(reasult);
	if(userData.containsKey(user) && userData.containsKey(pass)){
		System.out.println("User Authenticated");
	}
	else{
		System.out.println("Invalid UserName or Password");
	}
	
//	if (pass.equals(reasult)){
//		System.out.println("User Authenticated");
//	}
	}
}
