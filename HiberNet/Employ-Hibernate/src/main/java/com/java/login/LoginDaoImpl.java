package com.java.login;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.java.hib.SessionHelper;

public class LoginDaoImpl implements LoginDAO{
	SessionFactory sf;
	Session session;
	@Override
	public String addUser(Login login) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(login);
		transaction.commit();		
		return "User Added....";
	}
	@Override
	public Login authenticate(Login login) {
		sf = SessionHelper.getConnection();
		String pwd = EncryptPassword.getCode(login.getPassCode());
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Login.class);
		criteria.add(Restrictions.eqOrIsNull("userName", login.getUserName()));
		criteria.add(Restrictions.eqOrIsNull("passCode", pwd));
		Login log = (Login)criteria.uniqueResult(); 
		
		return log;
		
	}
	
	
}
