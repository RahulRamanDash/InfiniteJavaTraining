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
		System.out.println("L E A V E - A P P L I C A T I O N");
		System.out.println("O P T I O N S");
		System.out.println("-------------");
		System.out.println("1. Login as User");
		System.out.println("2. Login as Manager");
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
				System.out.println("5. write Leave Data In File");
				System.out.println("6. Read Leave Data From File");
				System.out.println("7. Exit");
				System.out.println("Enter Your Choice  ");
				System.out.println();
				choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					try {
						addLeaveMain();
					} catch (LeaveException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					showLeaveMain();
					break;
				case 3:
					searchLeaveMain();
					break;
				case 4:
					//deleteLeaveMain();
					System.out.println("Work in Progress...");
					break;
				case 5:
					try {
						writeLeaveFileMain();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 6:
					
					try {
						ReadLeaveFileMain();
					} catch (ClassNotFoundException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 7:
					break;
				default : 
					System.out.println("Invalid chocie (1 to 7 only)");
					break;
				}
				}while(choice!=7);
			break;
		case 2:
			int adminval;
			do {
				System.out.println("M A N A G E R - O P T I O N S");
				System.out.println("-----------------------------");
				System.out.println("1. Show Leave Application");
				System.out.println("2. Update Leave Status");
				System.out.println("3. Delete Leave Application");
				System.out.println("4. Exit");
				System.out.println("Enter Your Choice  ");
				adminval = sc.nextInt();
				
				switch (adminval) {
				case 1:
					showLeaveMain();
					break;
				case 2:
					try {
						ApproveDenyLeaveMain();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Welcome To Admin DashBoard");
					System.out.println("Work in progress");
					break;
				case 4:
					break;
					
				default : 
					System.out.println("Invalid chocie (1 to 4 only)");
					break;
				}
			}while(adminval !=4);
			break;
		case 3:
			System.out.println("Exiting the program");
			return;
		default : 
			System.out.println("Invalid chocie (1 to 3 only)");
			break;
	
		}
		}while(val !=3);
}
	public static void searchLeaveMain(){
		int leaveid;
		System.out.println("Enter LeaveID : ");
		leaveid = sc.nextInt();
		LeaveDetails leave = bal.searchLeaveBal(leaveid);
		if(leave!=null){
			System.out.println(leave);
		}
		else{
			System.out.println("Record Not Found...");
		}
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
		leavedata.setLeaveStatus(LeaveStatus.PENDING);
		System.out.println(bal.addLeaveBal(leavedata));
		
	}
	private static void ApproveDenyLeaveMain() throws Exception{
		int leaveid;
		System.out.println("Enter LeaveID : ");
		leaveid = sc.nextInt();
		
		System.out.println("Enter Leave Status(PENDING/ACCEPTED/REJECTED) ");
		String leavestatus=sc.next();
		
		System.out.println("Enter Manager's comment  ");
		String mgcomm = sc.next();
		System.out.println(bal.ApproveDenyLeaveBal(leaveid,mgcomm,leavestatus));
	
	}
}
