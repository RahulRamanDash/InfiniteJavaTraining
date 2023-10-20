package com.java.infinite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl  implements CustomerDAO {

	@Override
	public void addCustomer(Customer customer) throws ClassNotFoundException, SQLException  {
		Connection connection = ConnectionHelper.getConnection();
		 String cmd = "INSERT INTO HotelCustomer (Name,  checkInTime, checkOutTime, RoomNumber)"
		 		+ " VALUES (?, ?, ?, ?)";
		  PreparedStatement pst = connection.prepareStatement(cmd);
		  pst.setString(1, customer.getName());
		  pst.setTimestamp(2, new java.sql.Timestamp(customer.getCheckInTime().getTime()));
          pst.setTimestamp(3, new java.sql.Timestamp(customer.getCheckOutTime().getTime()));
          pst.setInt(4, customer.getRoomNumber());
          pst.executeUpdate();

	}

	@Override
	public Customer getCustomerById(int customerId) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM HotelCustomer WHERE CustomerID = ?";
        PreparedStatement pst = connection.prepareStatement(cmd);
        ResultSet resultSet = pst.executeQuery();
        pst.setInt(1, customerId);
        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            Timestamp checkInTime = resultSet.getTimestamp("CheckInTime");
            Timestamp checkOutTime = resultSet.getTimestamp("CheckOutTime");
            int roomNumber = resultSet.getInt("RoomNumber");
            return new Customer(customerId, name, checkInTime, checkOutTime, roomNumber);
            
        }
        return null;
	}
	
	@Override
	public List<Customer> getAllCustomers()throws ClassNotFoundException, SQLException {
	   	Connection connection = ConnectionHelper.getConnection();	
        String cmd = "SELECT * FROM HotelCustomer";
        PreparedStatement pst = connection.prepareStatement(cmd);
        ResultSet resultSet = pst.executeQuery();
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
   
            while (resultSet.next()) {
                int customerId = resultSet.getInt("CustomerID");
                String name = resultSet.getString("Name");
                Timestamp checkInTime = resultSet.getTimestamp("CheckInTime");
                Timestamp checkOutTime = resultSet.getTimestamp("CheckOutTime");
                int roomNumber = resultSet.getInt("RoomNumber");
                Customer Customer= new Customer(customerId, name, checkInTime, checkOutTime, roomNumber);
                customers.add(customer);
               
        }
        return customers;
    }
	

	@Override
	public void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionHelper.getConnection();
        String cmd = "UPDATE HotelCustomer SET Name = ?, CheckInTime = ?, CheckOutTime = ?, RoomNumber = ? WHERE CustomerID = ?";
        PreparedStatement pst = connection.prepareStatement(cmd);
           pst.setString(1, customer.getName());
           pst.setTimestamp(2, new java.sql.Timestamp(customer.getCheckInTime().getTime()));
           pst.setTimestamp(3, new java.sql.Timestamp(customer.getCheckOutTime().getTime()));
           pst.setInt(4, customer.getRoomNumber());
           pst.setInt(5, customer.getCustomerId());

          pst.executeUpdate();
		
	}

	@Override
	public void deleteCustomer(int customerId) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionHelper.getConnection();
		String cmd = "DELETE FROM HotelCustomer WHERE CustomerID = ?";
		PreparedStatement pst = connection.prepareStatement(cmd);
           pst.setInt(1, customerId);
            pst.executeUpdate();
	}        
}	
		 
