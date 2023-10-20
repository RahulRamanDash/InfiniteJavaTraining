package com.java.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAllComplaints {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // JDBC connection information (modify as needed)
            String jdbcUrl = "jdbc:mysql://localhost:3306/Complaint";
            String username = "root";
            String password = "india@123";

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // SQL query to select all complaints
            String sql = "SELECT * FROM Complaint";

            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Display the results
            while (resultSet.next()) {
                String complaintID = resultSet.getString("ComplaintID");
                String complaintType = resultSet.getString("ComplaintType");
                String cDescription = resultSet.getString("CDescription");
                String severity = resultSet.getString("Severity");
                String status = resultSet.getString("Status"); // If Status is stored as VARCHAR
                // You can also retrieve the Status enum if it has been converted

                // Display the complaint details
                System.out.println("Complaint ID: " + complaintID);
                System.out.println("Complaint Type: " + complaintType);
                System.out.println("Description: " + cDescription);
                System.out.println("Severity: " + severity);
                System.out.println("Status: " + status);
                System.out.println("--------------------------");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (connection, preparedStatement, resultSet)
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
