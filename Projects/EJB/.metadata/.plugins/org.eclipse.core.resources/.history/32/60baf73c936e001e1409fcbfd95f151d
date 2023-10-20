package com.java.ejb;

import java.sql.SQLException;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class PatientEjbImpl {
	public String redirectAddEjb(String did) throws NamingException, ClassNotFoundException, SQLException {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		 sessionMap.put("dId", did);
		 return "addPatient.jsp?faces-redirect=true";
		}
	
	public String addPatientEjb(PatientMaster patient, String doctorId) throws NamingException, ClassNotFoundException, SQLException {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PatientBeanRemote remote = PatientRemoteHelper.lookupRemoteStatelessEmploy();
		patient.setDoctorId(doctorId);
		remote.addPatient(patient);
		String patientId = remote.getpatientId();
		sessionMap.put("patientId", patientId);
		return "admitPatient.jsp?faces-redirect=true";
	}
//	public String getpatientIdEjb() throws NamingException, ClassNotFoundException, SQLException {
//		Map<String, Object> sessionMap =
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		PatientBeanRemote remote = PatientRemoteHelper.lookupRemoteStatelessEmploy();
//		String patientId = remote.getpatientId();
//		sessionMap.put("patientId", patientId);
//		return patientId;
//		}
}
