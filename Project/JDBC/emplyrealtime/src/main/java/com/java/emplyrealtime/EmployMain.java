package com.java.emplyrealtime;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class EmployMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("-------------");
			System.out.println("1. Show Employ Details ");
			System.out.println("2. Add Employ Details ");
			System.out.println("3. Search Employ Details ");
			System.out.println("4. Update Employ Details ");
			System.out.println("5. Delete Employ Details ");
			System.out.println("6. Exit");
			
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				showEmployMain();
				break;
			case 2:
				addEmployMain();
				break;
			case 3:
				searchEmployMain();
				break;
			case 4:
				updateEmployMain();
				break;
			case 5:
				deleteEmployMain();
				break;
			case 6:
				System.out.println("Exiting....");
				return;
			default:
				System.out.println("Enter a Valid Option...");
				return;
				
					
			}
			
			
		}while(choice!=6);
		
		
		

}

	private static void updateEmployMain() {
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employ Number ");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter Name");
		employ.setName(sc.next());
		System.out.println("Enter Gender ");
		employ.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Department");
		employ.setDept(sc.next());
		System.out.println("Enter Designation");
		employ.setDesig(sc.next());
		System.out.println("Enter Basic");
		employ.setBasic(sc.nextDouble());
		
		EmployDAO dao = new EmployDAOimpl();
		try {
			System.out.println(dao.updateEmployDao(employ));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
		


	private static void deleteEmployMain() {
		EmployDAO dao = new EmployDAOimpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Number ");
		int empno = sc.nextInt();
		try {
			System.out.println(dao.deleteEmployDao(empno));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

	private static void addEmployMain() {
		EmployDAO dao = new EmployDAOimpl();
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Number ");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter Name");
		employ.setName(sc.next());
		System.out.println("Enter Gender ");
		employ.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Department");
		employ.setDept(sc.next());
		System.out.println("Enter Designation");
		employ.setDesig(sc.next());
		System.out.println("Enter Basic");
		employ.setBasic(sc.nextDouble());
		
		try {
			System.out.println(dao.addEmployDao(employ));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	private static void searchEmployMain() {
		EmployDAO dao = new EmployDAOimpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Number ");
		int empno = sc.nextInt();
		try {
			Employ employ =dao.searchEmployDao(empno);
			if(employ!=null) {
				System.out.println(employ);
			}
			else {
				System.out.println("Record Not Found");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		}
		private static void showEmployMain() {
			EmployDAO dao = new EmployDAOimpl();
			try {
				List<Employ> employlist = dao.showEmployDao();
				for(Employ employ :employlist) {
					System.out.println(employ);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	

}
