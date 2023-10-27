package com.java.hms;

import java.util.List;

import javax.naming.NamingException;

public class PatientEjbImpl {
	public List<PatientMaster> showPatientEjb() throws NamingException {
		PatientBeanRemote remote = PatientRemoteHelper.lookupRemoteStatelessEmploy();
		return remote.showPatient();
		}
	
	public List<PatientReport> showPatientReportEjb() throws NamingException{
		PatientBeanRemote remote = PatientRemoteHelper.lookupRemoteStatelessEmploy();
		return remote.showPatientReport();
	}
	public String addPatientReportEjb(PatientReport report) throws NamingException {
		PatientBeanRemote remote = PatientRemoteHelper.lookupRemoteStatelessEmploy();
		remote.addPatientReport(report);
		return "showPatientReport.jsp?faces-redirect=true";
	}
}