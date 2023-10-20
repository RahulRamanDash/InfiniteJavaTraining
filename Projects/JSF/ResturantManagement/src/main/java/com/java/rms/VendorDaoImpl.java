package com.java.rms;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class VendorDaoImpl implements VenderDAO{
	
	SessionFactory sessionFactory;
	Session session;
	
	private String localCode;
	private int venId;
	
	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public List<Vendor> showVendorDao() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Vendor.class);
		List<Vendor> vendorList = criteria.list();
		System.out.println(vendorList);
		return vendorList;
	}
	
	public int getVendorId(String vendorName) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Vendor.class);
		criteria.add(Restrictions.eq("venname", vendorName));
		Vendor vendor = (Vendor) criteria.uniqueResult();
		return vendor.getVenid();
	}
	public void employLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.localCode = e.getNewValue().toString();
		this.venId = getVendorId(localCode);
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("venName", this.localCode);
		sessionMap.put("venId", venId);
	}
	public List<String> showVendorNames() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Vendor.class);
		Projection projection = Projections.property("venname"); 
		criteria.setProjection(projection); 
		List<String> list = criteria.list();
		System.out.println(list);
		return list;
	}

	@Override
	public String vendorLogin(Vendor vendor) {
		 Map<String, Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String encPass = EncryptPassword.getCode(vendor.getVenpassword());
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		cr.add(Restrictions.eqOrIsNull("venusername", vendor.getVenusername()));
		cr.add(Restrictions.eqOrIsNull("venpassword", encPass.trim()));
		cr.setProjection(Projections.rowCount());
		long count = (long)cr.uniqueResult();
		session.close();
		sessionFactory.close();

		if(count==1) {
			sessionMap.put("loggedVendor",  vendor.getVenusername());
			sessionFactory = SessionHelper.getConnection();
			session = sessionFactory.openSession();
			cr = session.createCriteria(Vendor.class);
			cr.add(Restrictions.eqOrIsNull("venusername", vendor.getVenusername()));
			Vendor vendorFound = (Vendor) cr.uniqueResult();
			sessionMap.put("vendorId", vendorFound.getVenid());
			System.out.println(vendorFound.getVenid());
			return "VendorDashboard.jsp?faces-redirect=true";
		}else {
			sessionMap.put("errorMessage", "Invalid Credentials....");
			return "VendorLogin.jsp?faces-redirect=true";
		}
	}
	
	
}
