package infinite.OtpApp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class OtpAppDaoImpl implements OtpAppDAO{
	PreparedStatement pst;
	Connection connection;
	
	public static int generateOtp() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	public static String generateResetKey() {
		int len=10;
		  String AlphaNumericString = "0123456789"
			         + "abcdefghijklmnopqrstuvxyz";
			  StringBuilder sb = new StringBuilder(len);
			  for (int i=0;i<len;i++) {
			   int index = (int)(AlphaNumericString.length()
			      * Math.random());
			   sb.append(AlphaNumericString
			      .charAt(index));
			  }
			  return sb.toString();
	}
	
	@Override
	public String createAccountDao(Customer customer) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String userid = customer.getCustomer_UserName();
		Customer customerfound = searchCustomerDao(userid);
		if (customerfound==null) {
		String pwd = EncryptPassword.getCode(customer.getCustomer_Password());
		String cmd = "INSERT INTO Customer(Customer_FirstName,Customer_LastName,Customer_UserName,Customer_Password,Customer_Email,Customer_PhoneNo,Customer_Status) VALUES (?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, customer.getCustomer_FirstName());
		pst.setString(2, customer.getCustomer_LastName());
		pst.setString(3, customer.getCustomer_UserName());
		pst.setString(4, pwd);
		pst.setString(5, customer.getCustomer_Email());
		pst.setString(6, customer.getCustomer_PhoneNo());
		pst.setString(7, "OTP PENDING");
		pst.executeUpdate();
		
		customerfound = searchCustomerDao(userid);
		int id = customerfound.getCust_ID();
		
		int otp = generateOtp();
		Date obj = new Date();
		java.sql.Date sqlDate = new java.sql.Date(obj.getTime());
		cmd = "Insert into otp(Cust_ID,otpCode,GeneratedOn) values(?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, id);
		pst.setInt(2, otp);
		pst.setDate(3, sqlDate);
		pst.executeUpdate();
		String body ="Welcome to Mr/Miss  " +customer.getCustomer_FirstName() + "\r\n"+
				"Your OTP Generated Successfully..." +"\r\n" + 
				"OTP is " +otp;
		MailSend.mailOtp(customer.getCustomer_Email(), "Otp Send Succesfully...", body);
		return "Otp Send To Email...";
		} else {
			return "User-Name already Exists...";
			}
	}

	@Override
	public Customer searchCustomerDao(String username) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from customer where Customer_UserName=?";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		if (rs.next()) {
			customer = new Customer();
			customer.setCust_ID(rs.getInt("Cust_ID"));
			customer.setCustomer_FirstName(rs.getString("Customer_FirstName"));
			customer.setCustomer_LastName(rs.getString("Customer_LastName"));
			customer.setCustomer_UserName(rs.getString("Customer_UserName"));
			customer.setCustomer_Password(rs.getString("Customer_Password"));
			customer.setCustomer_Email(rs.getString("Customer_Email"));
			customer.setCustomer_PhoneNo(rs.getString("Customer_Status"));
		}
		return customer;
	}

	@Override
	public String validateOtpDao(String username, int otp) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select OtpCode from otp where Cust_ID=(select Cust_ID from customer where Customer_UserName=?) order by otp_id desc limit 1;";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		int otpfromdb;
		if (rs.next()) {
			otpfromdb = rs.getInt("OtpCode");
		if(otp==otpfromdb) {
			cmd = "update customer set Customer_Status='active' where Customer_UserName=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, username);
			pst.executeUpdate();
			}else {
				return "Invalid Otp...";
			}
		}
		return "Account Created";
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

	@Override
	public String forgotPasswordDao(String username) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		Customer customerfound = searchCustomerDao(username);
		if (customerfound!=null) {
			String code = generateResetKey();
			String encCode = EncryptPassword.getCode(code);
			String cmd = "update customer set resetKey=? where Customer_UserName=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, encCode);
			pst.setString(2, username);
			pst.executeUpdate();
			
			String body ="Welcome to Mr/Miss  " +customerfound.getCustomer_FirstName() + "\r\n"+
					"Your Reset Key Generated Successfully..." +"\r\n" + 
					"Reset Key is " +code;
			MailSend.mailOtp(customerfound.getCustomer_Email(), "Otp Send Succesfully...", body);
			return "Reset Key Send To Email...";
		}
		return "User Not Found";
	}

	@Override
	public String resetPasswordDao(String username, String resetKey, String newPassword) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encCode = EncryptPassword.getCode(resetKey);
		String cmd = "select count(*) as res from customer where resetKey=? and Customer_UserName=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, encCode);
		pst.setString(2, username);
		ResultSet rs = pst.executeQuery();
		rs.next();
		if ( rs.getInt("res")==1) {
			String pwd = EncryptPassword.getCode(newPassword);
			cmd = "update customer set Customer_Password=? where Customer_UserName=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, pwd);
			pst.setString(2, username);
			pst.executeUpdate();
			}else {
				return "Invalid Reset Key or UserName";
			}
		return "Password Changed";
	}

}
