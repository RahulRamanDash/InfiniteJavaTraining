package com.java.jsf;

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

public class EmployDAOImpl {
	
	SessionFactory sf;
	Session session;
	
	public String localCode;
	
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public void employLocalCodeChanged(ValueChangeEvent e) {
		this.localCode = e.getNewValue().toString();
	}
	
	
	public List<String> getNames(){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		Projection projection = Projections.property("name");
		cr.setProjection(projection);
		List<String> list = cr.list();
		return list;
	}
	public List<String> getDepartments(){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		Projection projection = Projections.distinct(Projections.property("dept"));
		cr.setProjection(projection);
		List<String> list = cr.list();
		return list;
	}
	
	public List<Employ> getEmployListByDepartments(String dept){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.add(Restrictions.eq("dept", dept));
		List<Employ> employList = cr.list();
		return employList;
	}
	
	public List<String> showEmploy(){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class); 
		return cr.list();
	}
	
	public String validate(Login login) {
		String encPass = EncryptPassword.getCode(login.getPassCode());
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eqOrIsNull("userName", login.getUserName()));
		cr.add(Restrictions.eqOrIsNull("passCode", encPass.trim()));
		cr.setProjection(Projections.rowCount());
		long count = (long)cr.uniqueResult();
		
		if(count==1) {
			return "showDept.xhtml?faces-redirect=true";
		}else {
			sessionMap.put("errorMessage", "Invalid Credentials....");
			return "Login.xhtml?faces-redirect=true";
		}
		
		
		
	}

}
