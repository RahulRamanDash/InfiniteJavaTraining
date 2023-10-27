package com.java.hms;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class PatientBean
 */
@Stateless
@Remote(PatientBeanRemote.class)
public class PatientBean implements PatientBeanRemote {
	
	 @PersistenceContext(unitName = "HmsMgmtPU")
	 private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public PatientBean() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public List<PatientMaster> showPatient() {
		System.out.println("Entit Manager is  " +entityManager);
		Query query = entityManager.createQuery("SELECT e FROM PatientMaster e");
	    return (List<PatientMaster>) query.getResultList();
	}

	@Override
	public List<PatientReport> showPatientReport() {
		System.out.println("Entit Manager is  " +entityManager);
		Query query = entityManager.createQuery("SELECT e FROM PatientReport e");
	    return (List<PatientReport>) query.getResultList();
	}

	@Override
	public String addPatientReport(PatientReport report) {
		entityManager.persist(report);
		return "Patient Report Inserted...";
	}
    



}
