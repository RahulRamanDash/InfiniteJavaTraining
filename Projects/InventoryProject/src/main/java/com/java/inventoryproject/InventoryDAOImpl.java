package com.java.inventoryproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO{

	Connection connection;
	PreparedStatement pst;
	
	public String incrimentStockID() throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(stockid) as sid from stock";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			String sid = rs.getString("sid");
			String numstr = sid.substring(1);
			int num = Integer.parseInt(numstr);
			num+=1;
			String stockid = String.format("S%03d", num);
			return stockid;
		}else {
			return "S001";
		}
	}

	@Override
	public List<Stock> showStockDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from stock";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Stock stock = null;
		List<Stock> stockList = new ArrayList<Stock>();
		while(rs.next()) {
			stock = new Stock();
			stock.setStockid(rs.getString("stockid"));
			stock.setItemName(rs.getString("ItemName"));
			stock.setPrice(rs.getDouble("Price"));
			stock.setQuantityAvail(rs.getInt("QuantityAvail"));
			stockList.add(stock);
		}
		return stockList;
	}

	@Override
	public String addStockDao(Stock stock) throws SQLException, ClassNotFoundException {
		String var = incrimentStockID();
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into stock(stockid,ItemName,Price,QuantityAvail) values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, var);
		pst.setString(2, stock.getItemName());
		pst.setDouble(3, stock.getPrice());
		pst.setInt(4, stock.getQuantityAvail());
		pst.executeUpdate();
		
		return "Stock Added";
	}

	@Override
	public Stock searchStockDao(String stockid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from stock where stockid=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, stockid);
		ResultSet rs = pst.executeQuery();
		Stock stock = null;
		if (rs.next()) {
			stock = new Stock();
			stock.setStockid(rs.getString("stockid"));
			stock.setItemName(rs.getString("ItemName"));
			stock.setPrice(rs.getDouble("Price"));
			stock.setQuantityAvail(rs.getInt("QuantityAvail"));
		}
		return stock;
	}

}
