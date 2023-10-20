package com.java.jsp;

	
import java.sql.SQLException;
import java.util.Scanner;

public class ComplaintSearchApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming you have an instance of ComplaintDAO
        ComplaintDAO dao = new ComplaintDAOImpl(); // Initialize this appropriately

        System.out.println("Welcome to Complaint Search Console App");

        // Get user input for complaint ID
        System.out.print("Enter Complaint ID to search: ");
        String complaintId = scanner.nextLine();

        // Call the searchComplaintDAO method to search for the complaint
        Complaint complaint = null;
		try {
			complaint = dao.searchComplaintDAO(complaintId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (complaint != null) {
            System.out.println("Complaint found:");
            System.out.println(complaint.toString());
        } else {
            System.out.println("Complaint not found.");
        }

        scanner.close();
    }
}

