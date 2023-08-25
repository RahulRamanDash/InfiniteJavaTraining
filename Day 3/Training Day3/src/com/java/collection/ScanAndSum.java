package com.java.collection;

import java.util.Scanner;

public class ScanAndSum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num1,num2;
		System.out.println("Enter Two Numbers...");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		int sum= num1+num2;
		System.out.println("Sum is "+sum);
	}

}
