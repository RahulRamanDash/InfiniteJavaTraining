package com.java.inventoryproject;

public class Orders {
	private String OrderId;
	private String StockID;
	private int QtyOrd;
	private double billAmount;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(String orderId, String stockID, int qtyOrd, double billAmount) {
		super();
		OrderId = orderId;
		StockID = stockID;
		QtyOrd = qtyOrd;
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "Oders [OrderId=" + OrderId + ", StockID=" + StockID + ", QtyOrd=" + QtyOrd + ", billAmount="
				+ billAmount + "]";
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getStockID() {
		return StockID;
	}
	public void setStockID(String stockID) {
		StockID = stockID;
	}
	public int getQtyOrd() {
		return QtyOrd;
	}
	public void setQtyOrd(int qtyOrd) {
		QtyOrd = qtyOrd;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	

}
