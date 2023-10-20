package com.java.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EmployDaoImpl implements EmployDAO{

	SessionFactory sf;
	Session session;
	
	public List<Employ> showEmployCr() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Employ.class);
		criteria.addOrder(Order.asc("basic"));
		List<Employ> employList = criteria.list();
		return employList;
	}
	
	public Employ searchEmployCr(int empno) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Employ.class);
		criteria.add(Restrictions.eq("empno", empno));
		Employ employ = (Employ)criteria.uniqueResult();
		return employ;
	}
	@Override
	public List<Employ> showEmployDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("From Employ");
		List<Employ> employList = query.list();
		return employList;
	}

	@Override
	public Employ searchEmployDao(int empno) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("From Employ where empno="+empno);
		List<Employ> employList = query.list();
		if(employList.size()>0) {
			return employList.get(0);
		}
		return null;
	}

	@Override
	public String addEmployDao(Employ employ) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employ);
		transaction.commit();		
		return "Data Added to Employ Table";
	}

	@Override
	public String deleteEmployDao(int empno) {
		Employ employFound = searchEmployDao(empno);
		if(employFound!=null) {
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(employFound);
			transaction.commit();		
			return "Data Deleated From Employ Table";
		}else {
			return "Data Not Found";
		}
		
	}
	

}
