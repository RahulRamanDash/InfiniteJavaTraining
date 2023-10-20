package com.java.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EmployDAOImpl implements EmployDAO {

	SessionFactory sf;
	Session session;
	
	public List<Employ> showEmployCr() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.addOrder(Order.asc("basic"));
		List<Employ> employList = cr.list();
		return employList;
	}
	
	public Employ searchEmployCr(int empno) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.add(Restrictions.eq("empno", empno));
		Employ employ = (Employ)cr.uniqueResult();
		return employ;
	}
	
	
	@Override
	public List<Employ> showEmployDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("from Employ");
		List<Employ> employList = query.list();
		return employList;
	}
	@Override
	public String searchEmployDao(int empno) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("from Employ where empno="+empno);
		List<Employ> employList = query.list();
		Employ employ = employList.get(0);
		sessionMap.put("editEmploy", employ);
		return "updateEmploy.xhtml?faces-redirect=true";
	}
	@Override
	public String addEmployDao(Employ employ) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(employ);
		trans.commit();
		return "EmployShow.xhtml?faces-redirect=true";
	}
	
	@Override
	public String deleteEmployDao(int empno) {
		Employ employFound = searchEmployCr(empno);
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction trans = session.beginTransaction();
			session.delete(employFound);
			trans.commit();
			return "EmployShow.xhtml?faces-redirect=true";
		}

	@Override
	public String updateEmployDao(Employ employUpdated) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(employUpdated);
		trans.commit();
		return "EmployShow.xhtml?faces-redirect=true";
	}

}
