package com.java.genmap;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class GenMapDemo1 {

	public static void main(String[] args) {
		Map<Integer, String> names = new Hashtable<Integer, String>();
		names.put(1, "Rahul");
		names.put(2, "Rohan");
		names.put(3, "Ayush");
		names.put(4, "Rajesh");
		names.put(5, "Abhishak");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employ No : ");
		int empno=sc.nextInt();
		String name = names.getOrDefault(empno, "Not Found");
		System.out.println(name);
	}
}
