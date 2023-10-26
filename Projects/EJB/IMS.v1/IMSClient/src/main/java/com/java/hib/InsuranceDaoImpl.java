package com.java.hib;

import java.util.List;

import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class InsuranceDaoImpl{
	
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
		System.out.println(this.localCode);
	}

	public List<InsuranceDetails> showEmployDao() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(InsuranceDetails.class);
		System.out.println(cr.list());
		return cr.list();
	}
	public List<InsuranceDetails> getListOfEmploy(int firstRow, int rowCount) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<InsuranceDetails> cdList = null;
			session.beginTransaction();
			Criteria criteria = session.createCriteria(InsuranceDetails.class);
			criteria.setFirstResult(firstRow);
			criteria.setMaxResults(rowCount);
		return criteria.list();
	}
	
	public int countRows() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(InsuranceDetails.class);
			if (criteria != null) {
				return criteria.list().size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
