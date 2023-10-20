package com.java.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class CustomerDAOImpl implements CustomerDAO {

	PreparedStatement pst;
	Connection connection;
	
	public static int generateOtp() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	@Override
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		String userId = customer.getUserName();
		Customer customerFound = searchByUserName(userId);
		if (customerFound==null) {
			connection = ConnectionHelper.getConnection();
			customer.setStatus("OTP PENDING");
			String pwd = EncryptPassword.getCode(customer.getPassword());
			String cmd = "Insert into Customer(customer_Firstname,customer_LastName,customer_UserName,"
					+ "customer_Password,customer_Email,customer_PhoneNo,Customer_Status) values(?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, customer.getFirstName());
			pst.setString(2, customer.getLastName());
			pst.setString(3, customer.getUserName());
			pst.setString(4, pwd);
			pst.setString(5, customer.getEmail());
			pst.setString(6, customer.getPhoneNo());
			pst.setString(7, customer.getStatus());
			pst.executeUpdate();
			int otp = generateOtp();
			Date obj = new Date();
			java.sql.Date sqlDate = new java.sql.Date(obj.getTime());
			cmd = "Insert into otp(customer_UserName,otpCode,GeneratedOn) values(?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, customer.getUserName());
			pst.setInt(2, otp);
			pst.setDate(3, sqlDate);
			pst.executeUpdate();
			String body ="Welcome to Mr/Miss  " +customer.getFirstName() + "\r\n"+
					"Your OTP Generated Successfully..." +"\r\n" + 
					"OTP is " +otp;
			MailSend.mailOtp(customer.getEmail(), "Otp Send Succesfully...", body);
			return "User Created Successfully...";
		} else {
		// TODO Auto-generated method stub
		return "User-Name already Exists...";
		}
	}
	@Override
	public Customer searchByUserName(String userName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer where customer_UserName=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, userName);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		if (rs.next()) 
		{
			customer = new Customer();
			customer.setCustomerId(rs.getInt("Cust_ID"));
			customer.setFirstName(rs.getString("customer_Firstname"));
			customer.setLastName(rs.getString("customer_LastName"));
			customer.setUserName(rs.getString("customer_UserName"));
			customer.setPassword(rs.getString("customer_Password"));
			customer.setEmail(rs.getString("customer_Email"));
			customer.setPhoneNo(rs.getString("customer_PhoneNo"));
			customer.setStatus(rs.getString("Customer_Status"));
		}
		return customer;
	}

	@Override
	public String validateOtp(String user, int otpCode) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select count(*) cnt from otp where Customer_UserName=? AND OtpCode=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, user);
		pst.setInt(2, otpCode);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		Customer customer  = searchByUserName(user);;
		if (count==1) {
			
			MailSend.mailOtp(customer.getEmail(), "Otp Verified Successfully...", "You Can Use the Account Now...");
			cmd = "Update Customer set Customer_Status=? WHERE customer_UserName=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, "ACTIVE");
			pst.setString(2, user);
			pst.executeUpdate();
			return "OTP Verified Account Active...";
		}
		MailSend.mailOtp(customer.getEmail(), "Otp is wrong...", "Please Provider Proper Details...");
		return "Invalid Otp or UserName details provided...";
	}

	@Override
	public String loginDao(String username, String password) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String pwd = EncryptPassword.getCode(password);
		String cmd = "select count(*) as val from customer where Customer_UserName=? and Customer_Password=? and Customer_Status='active'";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1, username);
		pst.setString(2, pwd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		if (rs.getInt("val")==1) {
			return "Login Sucessfull";
		}else {
			return "Invalid Credential";
		}
	}

	
}
