package com.java.lib;

import java.sql.Date;

public class Tranbook {

	private String Username;
	private int BookId;
	private Date Fromdate;
	public Tranbook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tranbook(String username, int bookId, Date fromdate) {
		super();
		Username = username;
		BookId = bookId;
		Fromdate = fromdate;
	}
	@Override
	public String toString() {
		return "Tranbook [Username=" + Username + ", BookId=" + BookId + ", Fromdate=" + Fromdate + "]";
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public Date getFromdate() {
		return Fromdate;
	}
	public void setFromdate(Date fromdate) {
		Fromdate = fromdate;
	}
	
	
}
