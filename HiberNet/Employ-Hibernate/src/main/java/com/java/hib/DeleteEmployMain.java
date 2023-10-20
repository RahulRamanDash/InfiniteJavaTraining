package com.java.hib;

import java.util.Scanner;

public class DeleteEmployMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Number   ");
		int empno = sc.nextInt();
		EmployDAO dao = new EmployDaoImpl();
		System.out.println(dao.deleteEmployDao(empno));
	}
}
