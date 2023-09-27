package infinite.OtpApp;

import java.sql.SQLException;

public interface OtpAppDAO {
	String createAccountDao(Customer customer) throws ClassNotFoundException, SQLException;
	Customer searchCustomerDao(String username) throws ClassNotFoundException, SQLException;

}
