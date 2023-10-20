package com.java.bankproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankMain {
	static String user;
	static String pass;
	static int userAccountNo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val1;
		do {
			System.out.println("B A N K - A P P L I C A T I O N");
			System.out.println("-------------------------------");
			System.out.println("---------O P T I O N S---------");
			System.out.println("-------------------------------");
			System.out.println("1. New User ");
			System.out.println("2. Existing User ");
			System.out.println("3. Exit");
			System.out.println("-------------------------------");
			System.out.print("Enter Your Choice : ");
			val1 = sc.nextInt();
			
			switch (val1) {
			case 1:
				createAccountMain();
				break;
			case 2:	
				if(loginMain()) {
					System.out.println("Login Sucessful....");
					System.out.println("Welcome To the application....");
					int choice;
					do {
						System.out.println();
						System.out.println("B A N K - A P P L I C A T I O N");
						System.out.println("-------------------------------");
						System.out.println("---------O P T I O N S---------");
						System.out.println("-------------------------------");
						System.out.println("1. Show Account Details ");
						System.out.println("2. Check Balence ");
						System.out.println("3. Deposit Amount");
						System.out.println("4. Withdraw Amount");
						System.out.println("5. Close Account ");
						System.out.println("6. Exit");
						System.out.println("-------------------------------");
						System.out.print("Enter Your Choice : ");
						
						choice = sc.nextInt();
						try {
							getAccountNumberMain();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						switch (choice) {
						case 1:
							try {
								showAccountDetailsMain();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							break;
						case 2:
							checkBalenceMain();
							break;
						case 3:
							depositAmountMain();
							break;
						case 4:
							withdrawAmountMain();
							break;
						case 5:
							closeAccountMain();
							return;
						case 6:
							break;
						default:
							System.out.println("Enter a Valid Choice (1-6)");
							break;
						}
					}while(choice!=7);
					
				}
				else {
					System.out.println("Login Not Sucessful...");
					System.out.println("Account Not Created or Inactive...");
				}
			case 3:
				return;
			default:
				System.out.println("Enter a Valid Choice (1-3)");
				return;
			
			}
				
		}while (val1!=3);
					
}

	private static void searchAccountMain() {
		int accountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account No ");
		accountNo = sc.nextInt();
		BankDAO dao = new BankDAOimpl();
		try {
			System.out.println(dao.searchAccountDao(accountNo));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static boolean loginMain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------- L O G I N ---------");
		System.out.println("------------------------------");
		System.out.println("Hint :- username = firstname");
		System.out.println("Hint :- password = lastname");
		System.out.println("------------------------------");
		System.out.print("Enter Username : ");
		user=sc.next();
		System.out.print("Enter Password : ");
		pass=sc.next();
		System.out.println();
		BankDAO dao = new BankDAOimpl();
		int res = 0;
		try {
			res = dao.loginDao(user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public static void getAccountNumberMain() throws ClassNotFoundException, SQLException {
		BankDAOimpl impl = new BankDAOimpl();
		userAccountNo = impl.getAccountNumber(user, pass);
		
	}
	
	private static void showAccountDetailsMain() throws ClassNotFoundException, SQLException {

		BankDAO dao = new BankDAOimpl();
		try {
			List<Bank> accountlist = dao.showAccountDetailsDao(userAccountNo);
			for(Bank bank : accountlist) {
				System.out.println(bank);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void checkBalenceMain(){
		BankDAO dao = new BankDAOimpl();
		try {
			System.out.println(dao.checkBalenceDao(userAccountNo));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void createAccountMain() {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		System.out.println("Enter First Name");
		bank.setFirstName(sc.next());
		System.out.println("Enter Last Name");
		bank.setLastName(sc.next());
		System.out.println("Enter City");
		bank.setCity(sc.next());
		bank.setState(sc.next());
		bank.setAmount(sc.nextInt());
		bank.setCheqFacil(sc.next());
		bank.setAccountType(sc.next());
		System.out.println("Enter State");
		System.out.println("Enter Amount");
		System.out.println("Enter CheqFacil (YES/NO)");
		System.out.println("Enter AccountType");
		
		BankDAO dao = new BankDAOimpl();
		try {
			System.out.println(dao.createAccountDAO(bank));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void closeAccountMain() {
		BankDAO dao = new BankDAOimpl();
		try {
			System.out.println(dao.closeAccountDao(userAccountNo));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void depositAmountMain() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Deposit Amount ");
		int depositamount =sc.nextInt();
		
		BankDAO dao = new BankDAOimpl();
		try {
			System.out.println(dao.depositAmountDao(userAccountNo, depositamount));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void withdrawAmountMain() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Withdraw Amount ");
		int withdrawamount =sc.nextInt();
		
		BankDAO dao = new BankDAOimpl();
		try {
			System.out.println(dao.withdrawAmountDao(userAccountNo, withdrawamount));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
