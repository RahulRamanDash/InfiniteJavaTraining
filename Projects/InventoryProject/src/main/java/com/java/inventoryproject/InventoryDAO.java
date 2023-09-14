package com.java.inventoryproject;

import java.sql.SQLException;
import java.util.List;

public interface InventoryDAO {
	List<Stock> showStockDao() throws ClassNotFoundException, SQLException;
	String addStockDao(Stock stock) throws SQLException, ClassNotFoundException;
	Stock searchStockDao(String stockid) throws ClassNotFoundException, SQLException;
	
}
