package com.java.complaint;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ShowMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Complaint_ID : ");
		int ComplaintID = scanner.nextInt();
		ComplaintDAO dao = new ComplaintsDaoImpl();
		try {
			System.out.println(dao.searchComplaints(ComplaintID));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}