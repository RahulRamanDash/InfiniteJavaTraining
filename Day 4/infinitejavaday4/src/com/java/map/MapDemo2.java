package com.java.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MapDemo2 {
	
	public static void main(String[] args) {
		
	Map empData = new Hashtable();
	empData.put(1, new Employ( 1, "Rahul",1033220));
	empData.put(2, new Employ( 2, "Rohan",1033220));
	empData.put(3, new Employ( 3, "Ayush",1033220));
	empData.put(4, new Employ( 4, "Rajesh",1033220));
	empData.put(5, new Employ( 5, "Abhishak",1033220));
	
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Employ No :");
	int empno=sc.nextInt();
	String name = (String)empData.getOrDefault(empno, null);
	System.out.println(name);

	}
}
