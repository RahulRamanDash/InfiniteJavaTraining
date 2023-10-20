package com.java.ejb;

import java.sql.SQLException;

import javax.ejb.Remote;

@Remote
public interface PatientBeanRemote {
	String getpatientId() throws ClassNotFoundException, SQLException;
	String addPatient(PatientMaster patient) throws ClassNotFoundException, SQLException;
}
