package com.java.provider;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class PatientEnrollmentDaoImpl implements PatientEnrollmentDAO{

	
	SessionFactory sf;
	Session session;
	
	
	@Override
	public PatientEnrollment searchPatientEnrollment(String uhid) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(PatientEnrollment.class);
		criteria.add(Restrictions.eq("uhid", uhid));
		PatientEnrollment patientEnrollment =  (PatientEnrollment) criteria.uniqueResult();
		return patientEnrollment;
	}
	
}
