package infinite.OtpApp;

import java.sql.SQLException;
import java.util.Scanner;

public class addUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username : ");
		String UserName = sc.next();
		System.out.println("Password : ");
		String passWord = sc.next();
		OtpAppDAO dao = new OtpAppDaoImpl();
		try {
			System.out.println(dao.loginDao(UserName, passWord));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
