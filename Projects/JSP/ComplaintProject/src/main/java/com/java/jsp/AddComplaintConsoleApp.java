package com.java.jsp;

import java.sql.SQLException;
import java.util.Scanner;

public class AddComplaintConsoleApp {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Initialize the database connection and ComplaintDAO
        ComplaintDAOImpl complaintDAO = new ComplaintDAOImpl();

        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Input values for the new complaint
        System.out.println("Enter Complaint ID:");
        String complaintid = scanner.nextLine();

        System.out.println("Enter Complaint Type:");
        String complaintType = scanner.nextLine();

        System.out.println("Enter Description:");
        String cDescription = scanner.nextLine();

        System.out.println("Enter Severity:");
        String severity = scanner.nextLine();
        System.out.println("Enter status:");
        String status = scanner.nextLine();

        // Create a new Complaint object with the provided values
        Complaint newComplaint = new Complaint();
        newComplaint.setComplaintid(complaintid);
        newComplaint.setComplaintType(complaintType);
        newComplaint.setCDescription(cDescription);
        newComplaint.setSeverity(severity);

        // Call the addComplaintDAO method to insert the complaint
        String message = complaintDAO.addComplaintDAO(newComplaint);

        System.out.println(message);

        // Add a closeConnection method in your DAO to close the connection
    }
}

