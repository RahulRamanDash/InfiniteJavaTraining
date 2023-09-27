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
	public String incrimentOrderID() throws ClassNotFoundException, SQLException{
	    connection = ConnectionHelper.getConnection();
	    String cmd = "select max(OrderId) as oid from orders";
	    pst = connection.prepareStatement(cmd);
	    ResultSet rs = pst.executeQuery();
	    if (rs.next()) {
	        String oid = rs.getString("oid");
	        if (oid != null) {
	            String numstr = oid.substring(1);
	            int num = Integer.parseInt(numstr);
	            num += 1;
	            String Orderid = String.format("O%03d", num);
	            return Orderid;
	        } else {
	            return "O001";
	        }
	    } else {
	        return "O001";
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
		String sid = incrimentStockID();
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into stock(stockid,ItemName,Price,QuantityAvail) values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, sid);
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

	@Override
	public String placeOrderDao(String stockid, int quantity) throws ClassNotFoundException, SQLException {
		Stock stock = searchStockDao(stockid);
		double price = stock.getPrice();
		double billamt = price*quantity;
		if(stock.getQuantityAvail()>quantity) {
		String oid = incrimentOrderID();
		connection = ConnectionHelper.getConnection();
		String cmd1 = "insert into orders(OrderId,StockID,QtyOrd,billAmount) values(?,?,?,?)";
		pst = connection.prepareStatement(cmd1);
		pst.setString(1, oid);
		pst.setString(2, stockid);
		pst.setInt(3, quantity);
		pst.setDouble(4, billamt);
		pst.executeUpdate();
		
		
		connection = ConnectionHelper.getConnection();
		String cmd2 = "UPDATE stock SET QuantityAvail = QuantityAvail-? where stockid=?";
		pst = connection.prepareStatement(cmd2);
		pst.setInt(1, quantity);
		pst.setString(2, stockid);
		pst.executeUpdate();
		return "Order Placed";
		
		}
		else {
			return "Out Of Stock";
		}
	}
	@Override
	public List<Orders> showOrdersDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Orders order = null;
		List<Orders> orderList = new ArrayList<Orders>();
		while(rs.next()) {
			order = new Orders();
			order.setOrderId(rs.getString("OrderId"));
			order.setStockID(rs.getString("StockID"));
			order.setQtyOrd(rs.getInt("QtyOrd"));
			order.setBillAmount(rs.getDouble("billAmount"));
			orderList.add(order);
		}
		return orderList;
	}

}
