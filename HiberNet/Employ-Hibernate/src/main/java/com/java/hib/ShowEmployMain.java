package com.java.hib;

import java.util.List;
public class ShowEmployMain {
	public static void main(String[] args) {
		System.out.println("Data by Query Show");
		EmployDAO dao = new EmployDaoImpl();
		List<Employ> employList = dao.showEmployDao();
		for (Employ employ : employList) {
			System.out.println(employ);
		}
		
		System.out.println("Data by Cr Show");
		EmployDaoImpl impl = new EmployDaoImpl();
		List<Employ> employListCr = impl.showEmployCr();
		for (Employ employ : employListCr) {
			System.out.println(employ);
		}
		
	}
}
