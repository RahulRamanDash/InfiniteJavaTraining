package com.java.inventoryproject;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InventoryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("OPTIONS");
			System.out.println("1. Show Stock");
			System.out.println("2. Add Stock");
			System.out.println("3. Search Stock");
			System.out.println("3. Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				showStockMain();
				break;
			case 2:
				addStockMain();
				break;
			case 3:
				searchStockMain();
				break;
			case 4:
				return;
			}
	}while(choice!=4);

}
	//Main Closed

	private static void searchStockMain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter StockID");
		String stockid = sc.next();
		try {
			System.out.println(new InventoryDAOImpl().searchStockDao(stockid));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void addStockMain() {
		Stock stock = new Stock();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item Name");
		stock.setItemName(sc.nextLine());
		System.out.println("Enter Price");
		stock.setPrice(sc.nextDouble());
		System.out.println("Enter Available Quantity");
		stock.setQuantityAvail(sc.nextInt());
		
		try {
			System.out.println(new InventoryDAOImpl().addStockDao(stock));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void showStockMain() {
		InventoryDAO dao = new InventoryDAOImpl();
		try {
			List<Stock> stockList = dao.showStockDao();
			stockList.forEach(System.out::println);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
