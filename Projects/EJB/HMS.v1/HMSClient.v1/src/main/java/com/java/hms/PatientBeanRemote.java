package com.java.hms;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PatientBeanRemote {
	List<PatientMaster> showPatient();
	//String addPatient(PatientMaster patient) throws ClassNotFoundException, SQLException;
}
