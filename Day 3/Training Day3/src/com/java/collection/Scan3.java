package com.java.collection;

import java.util.Scanner;

import com.java.oops.Employ;

public class Scan3 {
	public static void main(String[] args) {
		Employ employ = new Employ();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter empno...");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter name...");
		employ.setName(sc.nextLine());
		
		
		System.out.println(employ);
	}

}
