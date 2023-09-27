package infinite.OtpApp;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter username");
		String username = sc.next();
		
//		Customer customer = new Customer();
//		System.out.println("fname");
//		customer.setCustomer_FirstName(sc.next());
//		System.out.println("lname");
//		customer.setCustomer_LastName(sc.next());
//		System.out.println("user");
//		customer.setCustomer_UserName(sc.next());
//		System.out.println("pass");
//		customer.setCustomer_Password(sc.next());
//		System.out.println("email");
//		customer.setCustomer_Email(sc.next());
//		System.out.println("phone");
//		customer.setCustomer_PhoneNo(sc.next());
		OtpAppDAO dao = new OtpAppDaoImpl();
		try {
			System.out.println(dao.searchCustomerDao(username));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
