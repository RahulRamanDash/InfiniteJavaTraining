package com.java.rms;

import java.sql.Date;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrdersDaoImpl implements OrdersDAO{
	
	SessionFactory sf;
	Session session;
	
	@Override
	public String placeOrderDao(Orders order) {
		java.util.Date utilDate = new java.util.Date();
		Date currentDate = new Date(utilDate.getTime());
		
		Map<String, Object> sessionMap =
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int custId = (int) sessionMap.get("customerId");
		int venId = (int) sessionMap.get("venId");
		int menuId = (int) sessionMap.get("menuId");
		double billAmount = (Double) sessionMap.get("billAmount");
		String payType = (String) sessionMap.get("payType");
		order.setCusid(custId);
		order.setVenid(venId);
		order.setWalsource(payType);
		order.setMenid(menuId);
		order.setOrdbillamount(billAmount);
		order.setOrdstatus(Ordstatus.PENDING);
		order.setOrddate(currentDate);
		
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(order);
		trans.commit();
		return "Dashboard.jsp?faces-redirect=true";
	}

}
