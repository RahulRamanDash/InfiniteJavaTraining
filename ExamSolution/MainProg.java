package com.java.exam;

import java.util.Scanner;

public class MainProg {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the mobile name : ");
		String mobileName = sc.nextLine();

		AbstractFactory factory = new MobileFactory();
		Mobile mobile = factory.getDetails(mobileName);
        
		if (mobile != null) {
			System.out.println("Mobile details:");
			mobile.name();
			mobile.model();
			mobile.price();
		} else {
			System.out.println("Invalid mobile name.");
		}
				
	}

}