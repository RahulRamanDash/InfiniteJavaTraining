package com.java.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDAOImpl implements EmployeeDAO{

	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Employee> showEmployeeDao() throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employee";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employee> employList = new ArrayList<Employee>();
		Employee employ = null;
		while(rs.next()) {
			employ = new Employee();
			employ.setEmpId(rs.getInt("empid"));
			employ.setEmpName(rs.getString("empname"));
			employ.setEmpEmail(rs.getString("EmpEmail"));
			employ.setDateOfJion(rs.getDate("DateOfJoin"));
			employ.setManagerId(rs.getInt("ManagerId"));
			employ.setLeaveAvail(rs.getInt("LeaveAvail"));
			
			employList.add(employ);
			
		}
		return employList;
	}

	@Override
	public Employee searchEmployeeDao(int empId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employee where empId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		if (rs.next()) {
			employee = new Employee();
			employee.setEmpId(rs.getInt("empId"));
			employee.setEmpName(rs.getString("EmpName"));
			employee.setEmpEmail(rs.getString("EmpEmail"));
			employee.setMobileNo(rs.getString("MobileNo"));
			employee.setDateOfJion(rs.getDate("DateOfJoin"));
			employee.setManagerId(rs.getInt("ManagerId"));
			employee.setLeaveAvail(rs.getInt("LeaveAvail"));
		}
		return employee;
	}
	
}
