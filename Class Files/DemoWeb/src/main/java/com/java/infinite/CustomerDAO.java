package com.java.infinite;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
	 
	    void addCustomer(Customer customer) throws ClassNotFoundException, SQLException ;
	    Customer getCustomerById(int customerId) throws SQLException, ClassNotFoundException;
	    List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException ;	  
	    void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException ;
	    void deleteCustomer(int customerId) throws SQLException, ClassNotFoundException ;
	
}
