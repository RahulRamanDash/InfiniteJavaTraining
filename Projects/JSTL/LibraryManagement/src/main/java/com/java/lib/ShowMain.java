package com.java.lib;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ShowMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter UserName : ");
		String username = sc.next();
		System.out.println("Enter BookID : ");
		int id = sc.nextInt();
		
		LibraryDaoImpl impl = new LibraryDaoImpl();
		try {
			Tranbook historylist = impl.searchIssueDao(username, id);
			System.out.println(historylist);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
