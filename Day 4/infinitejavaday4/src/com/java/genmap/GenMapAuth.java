package com.java.genmap;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class GenMapAuth {
	public static void main(String[] args) {
		Map<String, String> userData = new Hashtable<String, String>();
		userData.put("Rahul","password");
		userData.put("Rohan", "password");
		userData.put("Ayush", "password");
		userData.put("Rajesh", "password");
		userData.put("Abhishak", "password");
		
		String user, pass;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter UserName :");
		user = sc.next();
		if(userData.containsKey(user)){
			System.out.print("Enter Password :");
			pass = sc.next();
			String reasult = (String)userData.getOrDefault(user,"User Not Found..");
			//System.out.println(reasult);
			if(reasult.equals(pass)){
				System.out.println("User Authenticated");
				System.out.println("Login Sucessful...");
			}
			else{
				System.out.println("Invalid UserName or Password");
			}
	}
		else{
			System.out.println("User Not Found");
		}

	}
}
