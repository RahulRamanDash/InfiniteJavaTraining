package com.java.infinite;

import java.util.Date;

public class Customer {
	
	  private int customerId;
	    private String name;
	    private Date checkInTime;
	    private Date checkOutTime;
	    private int roomNumber;
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getCheckInTime() {
			return checkInTime;
		}
		public void setCheckInTime(Date checkInTime) {
			this.checkInTime = checkInTime;
		}
		public Date getCheckOutTime() {
			return checkOutTime;
		}
		public void setCheckOutTime(Date checkOutTime) {
			this.checkOutTime = checkOutTime;
		}
		public int getRoomNumber() {
			return roomNumber;
		}
		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}
		public Customer(int customerId, String name, Date checkInTime, Date checkOutTime, int roomNumber) {
			super();
			this.customerId = customerId;
			this.name = name;
			this.checkInTime = checkInTime;
			this.checkOutTime = checkOutTime;
			this.roomNumber = roomNumber;
		}
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", name=" + name + ", checkInTime=" + checkInTime
					+ ", checkOutTime=" + checkOutTime + ", roomNumber=" + roomNumber + "]";
		}
        
	    
}
