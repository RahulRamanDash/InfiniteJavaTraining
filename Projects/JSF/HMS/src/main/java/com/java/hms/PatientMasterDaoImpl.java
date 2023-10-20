package com.java.hms;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class PatientMasterDaoImpl implements PatientMasterDAO{

	SessionFactory sf;
	Session session;
	
	public String incrimentpatientId() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(PatientMaster.class);
		Projection projection = Projections.max("pid");
		criteria.setProjection(projection);
		String pid = (String) criteria.uniqueResult();
		if(pid!=null) {
			String numstr = pid.substring(1);
			int num = Integer.parseInt(numstr);
			num+=1;
			String patientid = String.format("S%04d", num);
			return patientid;
		}else {
			return "P0001";
		}
	}
	
	@Override
	public String addPatient(PatientMaster patient) {
		String pid = incrimentpatientId();
		patient.setPid(pid);
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(patient);
		trans.commit();
		return "addSuccess.jsp?faces-redirect=true";
	}
	

}
