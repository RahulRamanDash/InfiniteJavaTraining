package com.java.inventoryproject;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InventoryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("S H O P - A P P L I C A T I O N");
			System.out.println("-------------------------------");
			System.out.println("---------O P T I O N S---------");
			System.out.println("-------------------------------");
			System.out.println("1. Show Stock");
			System.out.println("2. Add Stock");
			System.out.println("3. Search Stock");
			System.out.println("4. PlaceOrder");
			System.out.println("5. Show Order");
			System.out.println("6. Exit");
			System.out.println("-------------------------------");
			System.out.print("Enter Your Choice : ");
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
				placeOrderMain();
				break;
			case 5:
				showOrderMain();
				break;
			case 6:
				return;
			default:
				System.out.println("Enter a Valid Option(1-6)");
				return;
			}
	}while(choice!=6);

}
	//Main Closed

	private static void showOrderMain() {
		InventoryDAO dao = new InventoryDAOImpl();
		try {
			List<Orders> orderList = dao.showOrdersDao();
			orderList.forEach(System.out::println);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void placeOrderMain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter StockID");
		String stockid = sc.next();
		System.out.println("Enter Quantity");
		int quantity = sc.nextInt();
		
		try {
			System.out.println(new InventoryDAOImpl().placeOrderDao(stockid, quantity));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

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
