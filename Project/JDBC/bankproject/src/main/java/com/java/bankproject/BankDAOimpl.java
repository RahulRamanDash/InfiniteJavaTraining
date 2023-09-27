package com.java.bankproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BankDAOimpl implements BankDAO{
	Connection connection;
	PreparedStatement pst;
	
	
	static int userAccountNo;
	public int getAccountNumber(String user, String pass) throws ClassNotFoundException, SQLException {
		connection = BankConnectionHelper.getConnection();
		String cmd ="select AccountNo from bank where firstname=? and lastname=? ";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, user);
		pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();
		rs.next();
		userAccountNo = rs.getInt("AccountNo");
		return userAccountNo;
		
	}
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		connection = BankConnectionHelper.getConnection();
		String cmd ="select case when max(accountNo) IS NULL THEN 1 else "
				+ " max(accountNo)+1 end accno from Bank";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno = rs.getInt("accno");
		
		return accno;
		
	}

	public int loginDao(String user, String pass) throws ClassNotFoundException, SQLException {
		connection = BankConnectionHelper.getConnection();
		String cmd = "select count(*) as res from bank where firstname=? and lastname=? and status='active'";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			rs.next();
			int res = rs.getInt("res");
			return res;
			
	}
	public String checkBalenceDao(int userAccountNo) throws ClassNotFoundException, SQLException {
		int bal;
		connection = BankConnectionHelper.getConnection();
		String cmd = "Select amount From Bank where AccountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, userAccountNo);
			ResultSet rs = pst.executeQuery();
			rs.next();
			bal = rs.getInt("amount");
		return "Your Account Balence is "+bal;
		
	}
	
	@Override
	public List<Bank> showAccountDetailsDao(int userAccountNo) throws SQLException, ClassNotFoundException {
	    connection = BankConnectionHelper.getConnection();
	    String cmd = "Select * From Bank where AccountNo=?";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, userAccountNo);
	    ResultSet rs = pst.executeQuery();
	    List<Bank> accountlist = new ArrayList<Bank>();
	    Bank bank = null;
	    while (rs.next()) {
	        bank = new Bank();
	        bank.setAccountNo(rs.getInt("AccountNo"));
	        bank.setFirstName(rs.getString("FirstName"));
	        bank.setLastName(rs.getString("LastName"));
	        bank.setCity(rs.getString("city"));
	        bank.setState(rs.getString("state"));
	        bank.setAmount(rs.getInt("amount"));
	        bank.setCheqFacil(rs.getString("CheqFacil"));
	        bank.setAccountType(rs.getString("AccountType"));
	        bank.setStatus(rs.getString("status"));
	        bank.setDateOfOpen(rs.getDate("DateOfOpen"));
	        accountlist.add(bank);
	        //accountlist.remove(6);
	    }
	    return accountlist;
	}


	@Override
	public String createAccountDAO(Bank bank) throws ClassNotFoundException, SQLException {
		int id = generateAccountNo();
		bank.setAccountNo(id);
		connection = BankConnectionHelper.getConnection();
		String cmd = "INSERT INTO BANK(AccountNo,FirstName,LastName,City,State,Amount,CheqFacil,AccountType) VALUES (?,?,?,?,?,?,?,?)";
		
		pst = connection.prepareStatement(cmd);
		
		pst.setInt(1, bank.getAccountNo());
		pst.setString(2, bank.getFirstName());
		pst.setString(3, bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setDouble(6, bank.getAmount());
		pst.setString(7, bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.executeUpdate();
		
		return "Account Created With Account No "+id;
	}
	@Override
	public Bank searchAccountDao(int accountNo) throws ClassNotFoundException, SQLException {
		connection = BankConnectionHelper.getConnection();
		String cmd = "select * from Bank where accountNo=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		Bank bank = null;
		if (rs.next()) {
			bank = new Bank();
			bank.setAccountNo(rs.getInt("accountNo"));
			bank.setFirstName(rs.getString("firstName"));
			bank.setLastName(rs.getString("lastName"));
			bank.setCity(rs.getString("city"));
			bank.setState(rs.getString("state"));
			bank.setAmount(rs.getInt("amount"));
			bank.setCheqFacil(rs.getString("cheqFacil"));
			bank.setAccountType(rs.getString("accountType"));
			bank.setDateOfOpen(rs.getDate("dateOfOpen"));
			bank.setStatus(rs.getString("status"));
		}
		return bank;
	}
	@Override
	public String closeAccountDao(int userAccountNo) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccountDao(userAccountNo);
		if(bank!=null) {
			connection = BankConnectionHelper.getConnection();
			String cmd = "Update Bank set status='inactive' where accountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, userAccountNo);
			pst.executeUpdate();
			return "Bank Account Closed \n"
					+ "Thank you For Using Our Bank...";
		}
		return "Account Not Found";
	}
	@Override
	public String depositAmountDao(int userAccountNo,int depositamount) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccountDao(userAccountNo);
		if(bank!=null) {
			connection = BankConnectionHelper.getConnection();
			String cmd = "Update Bank set amount=amount + ? where accountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, depositamount);
			pst.setInt(2, userAccountNo);
			pst.executeUpdate();
			//update trans table
			cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, userAccountNo);
			pst.setInt(2, depositamount);
			pst.setString(3, "C");
			pst.executeUpdate();
			return "Amount Credited....";
		}
		return "Account Not Found";
	}
	
	@Override
	public String withdrawAmountDao(int userAccountNo,int withdrawamount) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccountDao(userAccountNo);
		if(bank!=null) {
			int amount = bank.getAmount();
			
			if(amount-withdrawamount>=1000) {
				connection = BankConnectionHelper.getConnection();
				String cmd = "Update Bank set amount=amount - ? where accountNo=? status='active'";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, withdrawamount);
				pst.setInt(2, userAccountNo);
				pst.executeUpdate();
				//update trans table
				cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, userAccountNo);
				pst.setInt(2, withdrawamount);
				pst.setString(3, "D");
				pst.executeUpdate();
				return "Amount Debited....";
			}
			else {
				return "Insufficient Fund";
			}
		}
		return "Account Not Found";
	}

}
