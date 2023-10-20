package com.java.hib;

import java.sql.SQLException;

public interface PatientMasterDAO {
	String addPatientDao(PatientMaster patient) throws ClassNotFoundException, SQLException;
}
