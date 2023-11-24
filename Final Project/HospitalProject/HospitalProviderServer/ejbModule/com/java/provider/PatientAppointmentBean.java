package com.java.provider;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PatientAppointmentBean
 */
@Stateless
@Remote(PatientAppointmentBeanRemote.class)
public class PatientAppointmentBean implements PatientAppointmentBeanRemote {

	@PersistenceContext(unitName = "HMMgmtPU")
	 private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public PatientAppointmentBean() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public PatientAppointment searchAppointment(String appointmentId) {
		PatientAppointment appointment = entityManager.find(PatientAppointment.class, appointmentId);
		return appointment;
	}
	@Override
	public String updateAppointment(PatientAppointment appointment) {
		PatientAppointment appointmentFound = searchAppointment(appointment.getAppointmentId());
		if (appointmentFound!=null) {
			entityManager.merge(appointment);
			return "Appointment Record Updated...";
		}
		return "Appointment Not Found...";
	}
	

}
