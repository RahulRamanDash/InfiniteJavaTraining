package infinite.OtpApp;

import java.sql.SQLException;

public interface OtpAppDAO {
	String createAccountDao(Customer customer) throws ClassNotFoundException, SQLException;
	Customer searchCustomerDao(String username) throws ClassNotFoundException, SQLException;
	String validateOtpDao(String username,int otp) throws ClassNotFoundException, SQLException;
	String loginDao(String username, String password) throws SQLException, ClassNotFoundException;
	String forgotPasswordDao(String username) throws ClassNotFoundException, SQLException;
	String resetPasswordDao(String username,String resetKey,String newPassword) throws ClassNotFoundException, SQLException;
}
