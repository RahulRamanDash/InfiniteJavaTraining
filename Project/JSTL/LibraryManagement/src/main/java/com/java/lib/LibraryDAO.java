package com.java.lib;

import java.sql.SQLException;
import java.util.List;

public interface LibraryDAO {
	String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException;
	int authenticate(LibUsers libUsers) throws SQLException, ClassNotFoundException;
	public List<Tranbook> showHistoryDao(String username) throws ClassNotFoundException, SQLException;
	List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException;
	String issueBook(String userName, String bookId) throws ClassNotFoundException, SQLException;
	String returnBook(String userName, String bookId) throws ClassNotFoundException, SQLException;
}
