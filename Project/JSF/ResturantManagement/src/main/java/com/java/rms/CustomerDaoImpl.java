package com.java.rms;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CustomerDaoImpl implements CustomerDAO{

	SessionFactory sf;
	Session session;
	
	private String localCode;
	
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public void employLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.localCode = e.getNewValue().toString();
		System.out.println("Selected Wallet...." +localCode);
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("payType", localCode);
//		System.out.println(this.localCode);
//		this.venId = getVendorId(localCode);
//		System.out.println(this.venId);
	}
	@Override
	public List<Customer> showCustomerDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> customersList = criteria.list();
		return customersList;
	}
	@Override
	public String searchCustomerDetailsDao() {
	Map<String, Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	 String customerLoggined = (String)sessionMap.get("loggedCustomer");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		
		criteria.add(Restrictions.eq("cususername", customerLoggined));
		Customer customerData = (Customer) criteria.uniqueResult();
	//	sessionMap.put("customerFound", customerData);
		sessionMap.put("customerId", customerData.getCusid());
		return "CustomerInfo.jsp?faces-redirect=true";
	}
	
	@Override
	public String addCustomerDao(Customer customer) {
		String pwd = EncryptPassword.getCode(customer.getCuspassword());
		customer.setCuspassword(pwd);
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(customer);
		trans.commit();
		String body ="Welcome to Mr/Miss  " +customer.getCusname() + "\r\n"+
				"Your Account Created Successfully...";
		MailSend.mailOtp(customer.getCusemail(), "Otp Send Succesfully...", body);
		
		return "CustomerLogin.jsp?faces-redirect=true";
	}

	@Override
	public String customerLoginDao(Customer customer) {
		 Map<String, Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String encPass = EncryptPassword.getCode(customer.getCuspassword());
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eqOrIsNull("cususername", customer.getCususername()));
		cr.add(Restrictions.eqOrIsNull("cuspassword", encPass.trim()));
		cr.setProjection(Projections.rowCount());
		long count = (long)cr.uniqueResult();
		session.close();
		sf.close();

		if(count==1) {
			sessionMap.put("loggedCustomer",  customer.getCususername());
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.eqOrIsNull("cususername", customer.getCususername()));
			Customer customerFound = (Customer) cr.uniqueResult();
			sessionMap.put("customerFound", customerFound);
			sessionMap.put("customerId", customerFound.getCusid());
			return "Dashboard.jsp?faces-redirect=true";
		}else {
			sessionMap.put("errorMessage", "Invalid Credentials....");
			return "CustomerLogin.jsp?faces-redirect=true";
		}
	}
	@Override
	public String showCustomerWalletDao() {
		 Map<String, Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		 int custId = (Integer)sessionMap.get("customerId");
		 Criteria criteria = session.createCriteria(Wallet.class);
		 criteria.add(Restrictions.eq("custId", custId));
		 List<Wallet> walletList = criteria.list();
		 sessionMap.put("walletList", walletList);
		 return "CustomerWalletShow.jsp?faces-redirect=true";
	}
	
	public List<String> showCustomerWalleNames() {
		 Map<String, Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		int custId = (Integer)sessionMap.get("customerId");
		Criteria criteria = session.createCriteria(Wallet.class);
		criteria.add(Restrictions.eq("custId", custId));
		Projection projection = Projections.property("walletSource");
		criteria.setProjection(projection);
		List<String> walletList = criteria.list();
		System.out.println(walletList);
		return walletList;
	}
}
