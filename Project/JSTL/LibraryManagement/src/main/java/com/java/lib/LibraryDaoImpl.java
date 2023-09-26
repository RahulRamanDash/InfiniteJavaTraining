package com.java.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImpl implements LibraryDAO {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encPwd = new  EncryptPassword().getCode(libUsers.getPassWord());
		String cmd = "Insert into LibUsers(UserName,Password) "
				+ " values(?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, libUsers.getUserName());
		pst.setString(2, encPwd);
		pst.executeUpdate();
		return "User Account Created...";

	}

	@Override
	public int authenticate(LibUsers libUsers) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String encr= new EncryptPassword().getCode(libUsers.getPassWord());
		String cmd = "select count(*) cnt from LibUsers where userName=? AND Password=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, libUsers.getUserName());
		pst.setString(2, encr.trim());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}
	@Override
	public List<Tranbook> showHistoryDao(String username) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM tranbook where username =? order by fromdate desc;";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		List<Tranbook> historyList = new ArrayList<Tranbook>();
		Tranbook history = null;
		while(rs.next()) {
			history = new Tranbook();
			history.setUsername(rs.getString("Username"));
			history.setBookId(rs.getInt("BookId"));
			history.setFromdate(rs.getDate("Fromdate"));
			historyList.add(history);
		}
		
		return historyList;
	}

	@Override
	public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		String sql;
		boolean isValid=true;
		if(searchType.equals("id")) {
			sql = " SELECT * FROM Books WHERE Id = ? " ;
		} else if(searchType.equals("bookname")) {
			sql = " SELECT * FROM Books WHERE Name = ? " ;
		} else if(searchType.equals("authorname")) {
			sql = " SELECT * FROM Books WHERE Author = ? " ;
		} else if(searchType.equals("dept")) {
			sql = " SELECT * FROM Books WHERE Dept = ? " ;
		}
		else {
			isValid=false;
			sql = " SELECT * FROM Books";
		}
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(sql);
		if (isValid==true) {
			pst.setString(1, searchValue);
		} 
		ResultSet rs = pst.executeQuery();
		Books books = null;
		List<Books> booksList = new ArrayList<Books>();
		while(rs.next()) {
			books = new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setNoOfBooks(rs.getInt("TotalBooks"));
			booksList.add(books);
		}
		return booksList;

	}
	
	
	public Books searchBooksbyid(int id) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String sql = " SELECT * FROM Books WHERE Id = ?";
		pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Books books = null;
		while(rs.next()) {
			books = new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setNoOfBooks(rs.getInt("TotalBooks"));
		}
		return books;
	}

	@Override
	public String issueBook(String userName, String bookId) throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(bookId);
		Books bookdata = searchBooksbyid(id);
		int bookavail = bookdata.getNoOfBooks();
		if(bookavail>0) {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into tranbook(Username, BookId) values(?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, userName);
		pst.setString(2, bookId);
		pst.executeUpdate();
		
		
		cmd="update books set TotalBooks=TotalBooks-1 where id =?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, bookId);
		pst.executeUpdate();
		}
		return "Book Issued....";
	}

	@Override
	public String returnBook(String userName, String bookId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into tranbook(Username, BookId) values(?,?)";
		
		return "Book Returned...";
	}

}
