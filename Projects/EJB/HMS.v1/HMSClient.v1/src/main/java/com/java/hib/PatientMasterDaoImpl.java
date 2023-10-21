package com.java.hib;

import java.sql.SQLException;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class PatientMasterDaoImpl implements PatientMasterDAO{


	SessionFactory sf;
	Session session;
	
	public String generateOtp() {
		int len=6;
		  String AlphaNumericString = "0123456789";
			  StringBuilder sb = new StringBuilder(len);
			  for (int i=0;i<len;i++) {
			   int index = (int)(AlphaNumericString.length()
			      * Math.random());
			   sb.append(AlphaNumericString
			      .charAt(index));
			  }
			  return sb.toString();
	}
	
	public String setPassword(PatientMaster patient) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(PatientMaster.class);
		criteria.add(Restrictions.eqOrIsNull("username", patient.getUsername()));
		Projection projection = Projections.property("otpString");
		criteria.setProjection(projection);
		String otp = (String) criteria.uniqueResult();
		String pass = patient.getPassword();
		String pwd = EncryptPassword.getCode(pass);
		session.close();
		sf.close();
		if(otp.equals(patient.getOtpString())) {
			PatientMaster patientFound = searchPatientByUsername(patient.getUsername());
			patientFound.setPassword(pwd);
			patientFound.setStatus("ACTIVE");
			System.out.println(patientFound);
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(patientFound);
			transaction.commit();
			
			String body ="Welcome Mr/Miss  " + patientFound.getName() + "\r\n"+
					"Your OTP Generated Successfully..." +"\r\n" + 
					"OTP is " +otp;
			MailSend.mailOtp(patientFound.getEmail(), "Otp Send Succesfully...", body);
			return "patientLogin.jsp?faces-redirect=true";
		}
		else {
			Map<String, Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("otpError","Invalid UserName or Otp...");
			return "Invalid UserName or Otp...";
		}
	}
	
	@Override
	public String addPatientDao(PatientMaster patient) throws ClassNotFoundException, SQLException {
		String otp = generateOtp();
		patient.setOtpString(otp);
		patient.setStatus("PENDING");
		System.out.println(patient);
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(patient);
		transaction.commit();		
		return "setPassword.jsp?faces-redirect=true";
	}
	
	public PatientMaster searchPatientByUsername(String userName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Criteria cr = session.createCriteria(PatientMaster.class);
		cr.add(Restrictions.eq("username", userName));
		PatientMaster patient = (PatientMaster)cr.uniqueResult();
		return patient;
	}
	
	public String validateLogin(PatientMaster patient) {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String pwd = EncryptPassword.getCode(patient.getPassword());
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(PatientMaster.class);
		criteria.add(Restrictions.eqOrIsNull("username", patient.getUsername()));
		criteria.add(Restrictions.eqOrIsNull("password", pwd));
		criteria.setProjection(Projections.rowCount());
		long count = (long) criteria.uniqueResult();
			if(count==1) {
				sessionMap.put("loggedUser",patient.getUsername());
				return "Dashboard.jsp?faces-redirect=true";
			}else {
				sessionMap.put("loginError", "Invalid UserName or Password...");
				return "Invalid UserName or Password...";
			}
	}

}
