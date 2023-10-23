package com.java.bankproject;

import java.sql.SQLException;
import java.util.List;

public interface BankDAO {
	String createAccountDAO(Bank bank) throws ClassNotFoundException, SQLException;
	int loginDao(String user,String pass) throws ClassNotFoundException, SQLException;
	//List<Bank> showAccountDetailsDao(String user, String pass) throws SQLException, ClassNotFoundException;
	String checkBalenceDao(int userAccountNo) throws ClassNotFoundException, SQLException;
	Bank searchAccountDao(int accountNo) throws ClassNotFoundException, SQLException;
	String closeAccountDao(int AccountNo) throws ClassNotFoundException, SQLException;
	//String depositAmountDao(int AccountNo);
	String depositAmountDao(int AccountNo, int depositamount) throws ClassNotFoundException, SQLException;
	String withdrawAmountDao(int AccountNo, int withdrawamount) throws ClassNotFoundException, SQLException;
	List<Bank> showAccountDetailsDao(int userAccountNo) throws SQLException, ClassNotFoundException;

}