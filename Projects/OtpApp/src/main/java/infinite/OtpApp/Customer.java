package infinite.OtpApp;

import java.sql.Date;

public class Customer {
	private int Cust_ID;
	private String Customer_FirstName;
	private String Customer_LastName;
	private String Customer_UserName;
	private String Customer_Password;
	private String Customer_Email;
	private String Customer_PhoneNo;
	private String Customer_Status;
	private Date Customer_ActivatedOn;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int cust_ID, String customer_FirstName, String customer_LastName, String customer_UserName,
			String customer_Password, String customer_Email, String customer_PhoneNo, String customer_Status,
			Date customer_ActivatedOn) {
		super();
		Cust_ID = cust_ID;
		Customer_FirstName = customer_FirstName;
		Customer_LastName = customer_LastName;
		Customer_UserName = customer_UserName;
		Customer_Password = customer_Password;
		Customer_Email = customer_Email;
		Customer_PhoneNo = customer_PhoneNo;
		Customer_Status = customer_Status;
		Customer_ActivatedOn = customer_ActivatedOn;
	}
	@Override
	public String toString() {
		return "Customer [Cust_ID=" + Cust_ID + ", Customer_FirstName=" + Customer_FirstName + ", Customer_LastName="
				+ Customer_LastName + ", Customer_UserName=" + Customer_UserName + ", Customer_Password="
				+ Customer_Password + ", Customer_Email=" + Customer_Email + ", Customer_PhoneNo=" + Customer_PhoneNo
				+ ", Customer_Status=" + Customer_Status + ", Customer_ActivatedOn=" + Customer_ActivatedOn + "]";
	}
	public int getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(int cust_ID) {
		Cust_ID = cust_ID;
	}
	public String getCustomer_FirstName() {
		return Customer_FirstName;
	}
	public void setCustomer_FirstName(String customer_FirstName) {
		Customer_FirstName = customer_FirstName;
	}
	public String getCustomer_LastName() {
		return Customer_LastName;
	}
	public void setCustomer_LastName(String customer_LastName) {
		Customer_LastName = customer_LastName;
	}
	public String getCustomer_UserName() {
		return Customer_UserName;
	}
	public void setCustomer_UserName(String customer_UserName) {
		Customer_UserName = customer_UserName;
	}
	public String getCustomer_Password() {
		return Customer_Password;
	}
	public void setCustomer_Password(String customer_Password) {
		Customer_Password = customer_Password;
	}
	public String getCustomer_Email() {
		return Customer_Email;
	}
	public void setCustomer_Email(String customer_Email) {
		Customer_Email = customer_Email;
	}
	public String getCustomer_PhoneNo() {
		return Customer_PhoneNo;
	}
	public void setCustomer_PhoneNo(String customer_PhoneNo) {
		Customer_PhoneNo = customer_PhoneNo;
	}
	public String getCustomer_Status() {
		return Customer_Status;
	}
	public void setCustomer_Status(String customer_Status) {
		Customer_Status = customer_Status;
	}
	public Date getCustomer_ActivatedOn() {
		return Customer_ActivatedOn;
	}
	public void setCustomer_ActivatedOn(Date customer_ActivatedOn) {
		Customer_ActivatedOn = customer_ActivatedOn;
	}
	
	
}
