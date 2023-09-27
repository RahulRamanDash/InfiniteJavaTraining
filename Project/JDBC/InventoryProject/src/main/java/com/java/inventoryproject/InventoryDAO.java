package com.java.inventoryproject;

import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public interface InventoryDAO {
	List<Stock> showStockDao() throws ClassNotFoundException, SQLException;
	String addStockDao(Stock stock) throws SQLException, ClassNotFoundException;
	Stock searchStockDao(String stockid) throws ClassNotFoundException, SQLException;
	String placeOrderDao(String stockid, int quantity) throws ClassNotFoundException, SQLException;
	List<Orders> showOrdersDao() throws ClassNotFoundException, SQLException;
}
