package com.java.ejb;

import java.sql.SQLException;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PatientBean
 */
@Stateless
@Remote(PatientBeanRemote.class)
public class PatientBean implements PatientBeanRemote {
	static PatientMasterDAO patientDao;
	
	static {
		patientDao = new PatientMasterDaoImpl();
	}
	
    /**
     * Default constructor. 
     */
    public PatientBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addPatient(PatientMaster patient) throws ClassNotFoundException, SQLException {
		return patientDao.addPatient(patient);
	}

}
