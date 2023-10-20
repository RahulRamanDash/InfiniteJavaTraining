package com.java.lms;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	//List<Employee> showEmployDao() throws SQLException, ClassNotFoundException;
	Employee searchEmployeeDao(int empId) throws ClassNotFoundException, SQLException;
	List<Employee> showEmployeeDao() throws ClassNotFoundException, SQLException;
}
