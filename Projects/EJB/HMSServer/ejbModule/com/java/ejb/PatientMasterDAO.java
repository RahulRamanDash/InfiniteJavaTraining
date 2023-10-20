package com.java.ejb;

import java.sql.SQLException;

public interface PatientMasterDAO {
	String getpatientIdDao() throws ClassNotFoundException, SQLException;
	String addPatientDao(PatientMaster patient) throws ClassNotFoundException, SQLException;
}
