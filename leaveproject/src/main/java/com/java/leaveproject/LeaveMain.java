package com.java.leaveproject;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LeaveMain {

	static LeaveBAL bal;
	static Scanner sc;
	
	static {
		bal = new LeaveBAL();
		sc = new Scanner(System.in);
	}
	
	
	
	
	public static void main(String[] args) throws ParseException {
		
		int val;
		do {
		System.out.println("O P T I O N S");
		System.out.println("-------------");
		System.out.println("1. Login as User");
		System.out.println("2. Login as Admin");
		System.out.println("3. Exit");
		System.out.println("Enter Your Choice  ");
		val = sc.nextInt();
		switch(val) {
		case 1:
			int choice;
			do {
				System.out.println("O P T I O N S");
				System.out.println("-------------");
				System.out.println("1. Add Leave Application");
				System.out.println("2. Show Leave Application");
				System.out.println("3. Search Leave Application");
				System.out.println("4. Delete Leave Application");
				System.out.println("5. Update Leave Application");
				System.out.println("6. write Leave Data In File");
				System.out.println("7. Read Leave Data From File");
				System.out.println("8. Exit");
				System.out.println("Enter Your Choice  ");
				choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					try {
						addLeaveMain();
					} catch (LeaveException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				case 2:
					showLeaveMain();
					break;
				case 6:
					try {
						writeLeaveFileMain();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 7:
					
					try {
						ReadLeaveFileMain();
					} catch (ClassNotFoundException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 8:
					return;
				default : 
					System.out.println("Invalid chocie (1 to 8 only)");
					break;
				}
				}while(choice!=8);
			break;
		case 2:
			int adminval;
			do {
				System.out.println("A D M I N - O P T I O N S");
				System.out.println("-------------");
				System.out.println("1. Add Leave Application");
				System.out.println("2. Show Leave Application");
				System.out.println("3. Search Leave Application");
				System.out.println("4. Delete Leave Application");
				System.out.println("5. Update Leave Application");
				System.out.println("8. Exit");
				System.out.println("Enter Your Choice  ");
				adminval = sc.nextInt();
				
				switch (adminval) {
				case 1:
					System.out.println("Welcome To Admin DashBoard");
					System.out.println("Work in progress");
					break;
				case 2:
					System.out.println("Welcome To Admin DashBoard");
					System.out.println("Work in progress");
					break;
				case 3:
					System.out.println("Welcome To Admin DashBoard");
					System.out.println("Work in progress");
					break;
				case 4:
					System.out.println("Welcome To Admin DashBoard");
					System.out.println("Work in progress");
					break;
				case 5:
					System.out.println("Welcome To Admin DashBoard");
					System.out.println("Work in progress");
					break;
				case 6:
					return;
					
				default:
					break;
				}
			}while(adminval !=6);
		case 3:
			return;
	
		}
		}while(val !=3);
}
	public static void ReadLeaveFileMain() throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println(bal.ReadLeaveFileBal());
	}
	public static void writeLeaveFileMain() throws FileNotFoundException, IOException{
		System.out.println(bal.writeLeaveFileBal());
	}

	private static void showLeaveMain() {
		List<LeaveDetails> leaveList= bal.showLeaveBal();
		for (LeaveDetails leavedata : leaveList) {
			System.out.println(leavedata);
		}
	}
	
	public static void addLeaveMain() throws LeaveException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		LeaveDetails leavedata = new LeaveDetails();
		System.out.println("Enter Employ Number  ");
		leavedata.setEmpno(sc.nextInt());
		System.out.println("Enter Name  ");
		leavedata.setName(sc.next());
	
		
		System.out.println("Enter Leave Start Date ");
		String startDate = sc.next();
		Date stDate = sdf.parse(startDate);
		leavedata.setLeaveStartDate(stDate);	
		System.out.println("Enter Leave End Date ");
		String lastDate = sc.next();
		Date ltDate = sdf.parse(lastDate);
		leavedata.setLeaveEndDate(ltDate);
		System.out.println("Enter Leave Type (EL/PL/ML)");
		leavedata.setLeaveType(LeaveType.valueOf(sc.next()));
		System.out.println("Enter Manager Comments ");
		leavedata.setManagerComments(sc.next());
		leavedata.setLeaveStatus(LeaveStatus.PENDING);
		System.out.println(bal.addLeaveBal(leavedata));
		
	}
	
	
}
