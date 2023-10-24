package com.java.hib;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CustomerDetailsDaoImpl implements CustomerDetailsDAO {

	SessionFactory sf;
	Session session;

	public String generateOtp() {
		int len = 6;
		String AlphaNumericString = "0123456789";
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	@Override
	public List<CustomerDetails> showCustomerDetails() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(CustomerDetails.class);
		List<CustomerDetails> customerList = criteria.list();
		return customerList;
	}

	@Override
	public String addCustomerDao(CustomerDetails customerNew) {
		CustomerDetails customerFound = searchCustomer(customerNew.getUserName());
		if (customerFound == null) {
			customerNew.setStatus(Status.valueOf("Inactive"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = customerNew.getDateOfBirth();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			customerNew.setDateOfBirth(sqlDate);
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(customerNew);
			transaction.commit();

			setOtp(customerNew.getUserName());
			return "setPassword.jsp?faces-redirect=true";
		} else {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("signinError", "UserName Already Exist....");
			return "";
		}
	}

	public void setOtp(String userName) {
		String otp = generateOtp();
		CustomerAuthorization auth = new CustomerAuthorization();
		CustomerDetails customerFound = searchCustomer(userName);
		auth.setCustId(customerFound.getCustId());
		auth.setOtp(otp);

		String body = "Welcome Mr/Miss  " + customerFound.getUserName() + "\r\n" + "Your OTP Generated Successfully..."
				+ "\r\n" + "OTP is " + otp;
		System.out.println(customerFound.getEmail());
		MailSend.mailOtp(customerFound.getEmail(), "Otp Send Succesfully...", body);

		auth.setStatus("Inactive");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(auth);
		transaction.commit();
	}

	public CustomerDetails searchCustomer(String userName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(CustomerDetails.class);
		cr.add(Restrictions.eq("userName", userName));
		CustomerDetails customerFound = (CustomerDetails) cr.uniqueResult();
		return customerFound;
	}

	public CustomerAuthorization searchCustomerAuthorization(int cusId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(CustomerAuthorization.class);
		cr.add(Restrictions.eq("custId", cusId));
		CustomerAuthorization authFound = (CustomerAuthorization) cr.uniqueResult();
		return authFound;
	}

	public String setPassword(CustomerDetails customer, CustomerAuthorization cusAuth) {
		CustomerDetails customerFound = searchCustomer(customer.getUserName());
		int cusId = customerFound.getCustId();
		CustomerAuthorization authFound = searchCustomerAuthorization(cusId);
		String otp = authFound.getOtp();
		System.err.println("Otp From db" + otp);
		if (cusAuth.getOtp().equals(authFound.getOtp())) {
			String pwd = EncryptPassword.getCode(customer.getPassCode());
			customerFound.setPassCode(pwd);
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(customerFound);
			transaction.commit();

			setStatusInAuth(cusId);
			return "customerLogin.jsp?faces-rediret=true";
		} else {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("otpError", "Invalid UserName or Otp...");
			return "";
		}
	}
	public void setStatusInCustomerDetails() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String loggedUser = (String) sessionMap.get("loggedUser");
		CustomerDetails customerFound = searchCustomer(loggedUser);
		customerFound.setStatus(Status.valueOf("Active"));
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(customerFound);
		transaction.commit();
	}

	public void setStatusInAuth(int custId) {
		CustomerAuthorization auth = searchCustomerAuthorization(custId);
		auth.setStatus("Active");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(auth);
		transaction.commit();
	}

	public String validateLogin(CustomerDetails customer) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String pwd = EncryptPassword.getCode(customer.getPassCode());
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(CustomerDetails.class);
		criteria.add(Restrictions.eqOrIsNull("userName", customer.getUserName()));
		criteria.add(Restrictions.eqOrIsNull("passCode", pwd));
		criteria.add(Restrictions.eqOrIsNull("passCode", pwd));
		criteria.setProjection(Projections.rowCount());
		long count = (long) criteria.uniqueResult();

		CustomerDetails customerFound = searchCustomer(customer.getUserName());
		int cusId = customerFound.getCustId();
		CustomerAuthorization authFound = searchCustomerAuthorization(cusId);
		if (count == 1) {
			if (authFound.getStatus().equals("Active")) {	
				sessionMap.put("loggedCustId", authFound.getCustId());
				sessionMap.put("loggedUser", customer.getUserName());
				return "userDashboard.jsp?faces-redirect=true";
			} else {
				sessionMap.put("loginError", "Account is Inactive...");
				return "";
			}
		} else {
			sessionMap.put("loginError", "Invalid UserName or Password...");
			return "Invalid UserName or Password...";
		}
	}

}
