package com.java.hib;

import java.util.List;
import java.util.Scanner;

public class SearchEmployMain {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter Employ Number : ");
		int empno = scanner.nextInt();
		EmployDAO dao = new EmployDaoImpl();
		Employ employ = dao.searchEmployDao(empno);
		if (employ!=null) {
			System.out.println("Search By Query");
			System.out.println(employ);
		}else {
			System.out.println("Data Not Found....");
		}
		EmployDaoImpl daoCr = new EmployDaoImpl();
		employ = daoCr.searchEmployCr(empno);
		if (employ!=null) {
			System.out.println("Seaech by Cr");
			System.out.println(employ);
		}else {
			System.out.println("Data Not Found....");
		}
	}
}