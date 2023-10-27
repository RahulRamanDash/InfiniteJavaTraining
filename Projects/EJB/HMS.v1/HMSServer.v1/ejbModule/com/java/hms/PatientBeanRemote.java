package com.java.hms;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PatientBeanRemote {
	List<PatientMaster> showPatient();
	List<PatientReport> showPatientReport();
	String addPatientReport(PatientReport report);
}
