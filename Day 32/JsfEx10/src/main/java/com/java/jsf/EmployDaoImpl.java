package com.java.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;

public class EmployDaoImpl implements EmployDAO{
	Session session;
	@Override
	public List<Employ> showEmployDao() {
		session = SessionHelper.getConnection().openSession();
		Query query = session.getNamedQuery("showEmploy");
		List<Employ> employList = query.list();
		return employList;
	}
	@Override
	public String searchEmployDao(int empno) {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session = SessionHelper.getConnection().openSession();
		Query query = session.getNamedQuery("searchEmploy");
		query.setParameter("empno", empno);
		Employ employ = (Employ)query.uniqueResult();
		sessionMap.put("employFound", employ);
		return "searchEmploy.jsp?faces-redirect=true";
	}
	
}
