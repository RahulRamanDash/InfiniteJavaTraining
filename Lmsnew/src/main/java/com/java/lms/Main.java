package com.java.lms;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
				int choice1;
				do {
					System.out.println("OPTIONS");
					System.out.println("1. Show Employ Details");
					System.out.println("2. Search Employ Details");
					System.out.println("3. Apply Leave");
					System.out.println("4. Search Leave By EmployID");
					System.out.println("5. Sear Leave By LeaveID");
					System.out.println("6. Approve OR Deny");
					System.out.println("7. Exit");
					System.out.println("Enter Your Choice : ");
					choice1 = sc.nextInt();
					switch(choice1) {
					case 1:
						showEmployMain();
						break;
					case 2:
						searchEmployMain();
						break;
					case 3:
						applyLeaveMain();
						break;
					case 4:
						showLeaveMain();
						break;
					case 5:
						searchLeaveMain();
						break;
					case 6:
						approveDenyMain();
						break;
					case 7:
						break;
					}
				}while(choice1!=7);
		

	}

	//Employ main

	private static void showEmployMain() {
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			List<Employee> employeeList = dao.showEmployeeDao();
			employeeList.forEach(System.out::println);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void searchEmployMain() {
		int empId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id  ");
		empId = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			Optional<Employee> employee = Optional.ofNullable(dao.searchEmployeeDao(empId));
			if (employee.isPresent()) {
				System.out.println(employee);
			} else {
				System.out.println("Not Found...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//Leave Main
	
	
	
	private static void showLeaveMain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter EmployID");
		int empno = sc.nextInt();
		LeaveDetailsDAO dao = new LeaveDetailsDAOImpl();
		try {
			List<LeaveDetails> leaveList = dao.showLeaveDao(empno);
			leaveList.forEach(System.out::println);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void searchLeaveMain() {
		int LeaveId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Leave Id  ");
		LeaveId = sc.nextInt();
		LeaveDetailsDAO dao = new LeaveDetailsDAOImpl();
		try {
			Optional<LeaveDetails> leave = Optional.ofNullable(dao.searchLeaveDao(LeaveId));
			if (leave.isPresent()) {
				System.out.println(leave);
			} else {
				System.out.println("Not Found...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void applyLeaveMain() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    LeaveDetails leaveDetails = new LeaveDetails(); // Initialize a new LeaveDetails object
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter EmployID");
	    leaveDetails.setEmpId(sc.nextInt());
	    
	    System.out.println("Enter Leave Start Date (yyyy-MM-dd): ");
	    try {
	        String startDateStr = sc.next();
	        java.util.Date startDate = sdf.parse(startDateStr);
	        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
	        leaveDetails.setLeaveStartDate(sqlStartDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return; // Terminate the method if date parsing fails
	    }
	    
	    System.out.println("Enter Leave End Date (yyyy-MM-dd): ");
	    try {
	        String endDateStr = sc.next();
	        java.util.Date endDate = sdf.parse(endDateStr);
	        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
	        leaveDetails.setLeaveEndDate(sqlEndDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return; // Terminate the method if date parsing fails
	    }
	    
	    System.out.println("Enter Leave Type: ");
	    System.out.println("Options: SICK, VACATION, UNPAID"); // Assuming LeaveType is an enum with these values
	    leaveDetails.setLeaveType(LeaveType.valueOf(sc.next()));
	    
	    System.out.println("Enter Leave Reason: ");
	    leaveDetails.setLeaveReason(sc.next());
	    
	    try {
	        System.out.println(new LeaveDetailsDAOImpl().applyLeave(leaveDetails));
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}


	
	
	private static void approveDenyMain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter LeaveID ");
		int leaveid = sc.nextInt();
		System.out.println("Enter ManagerID ");
		int managerid = sc.nextInt();
		System.out.println("Enter Status(YES/NO) ");
		String status = sc.next();
		System.out.println("Enter Manager Comment ");
		String mgcmt = sc.next();
		
		LeaveDetailsDAO dao = new LeaveDetailsDAOImpl();
		try {
			System.out.println(dao.ApproveDeny(leaveid, managerid, status, mgcmt));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	





}