package com.java.provider;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class PatientAppointmentController {
	
    private PatientAppointment appointment;
    private PatientAppointmentDaoImpl appointmentImpl;
    private JsfPaginationBean pageDao;
	public PatientAppointment getAppointment() {
		return appointment;
	}
	public void setAppointment(PatientAppointment appointment) {
		this.appointment = appointment;
	}
	public PatientAppointmentDaoImpl getAppointmentImpl() {
		return appointmentImpl;
	}
	public void setAppointmentImpl(PatientAppointmentDaoImpl appointmentImpl) {
		this.appointmentImpl = appointmentImpl;
	}
	public JsfPaginationBean getPageDao() {
		return pageDao;
	}
	public void setPageDao(JsfPaginationBean pageDao) {
		this.pageDao = pageDao;
	}
    
    
	
	
	
	
	
	
	
	
	public boolean addValid() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		return true;
	}
}
