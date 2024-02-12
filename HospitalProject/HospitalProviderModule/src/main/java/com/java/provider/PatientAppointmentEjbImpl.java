package com.java.provider;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class PatientAppointmentEjbImpl {

	public String searchEmploy(String appointmentId) throws NamingException {
		PatientAppointmentBeanRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
		PatientAppointment appointment = remote.searchAppointment(appointmentId);
		Map<String,Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		 sessionMap.put("editAppointment", appointment);
		 return "UpdatePatientAppointment.jsp?faces-redirect=true";
	}
	
	public String updateEmployEjb(PatientAppointment appointment) throws NamingException, ClassNotFoundException  {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		System.out.println("update ejb working");
		FacesContext context = FacesContext.getCurrentInstance();
		PatientAppointmentBeanRemote remote =
				RemoteHelper.lookupRemoteStatelessEmploy();
		remote.updateAppointment(appointment);
		context.addMessage("successMsg", new FacesMessage("Appointment Updated Sucessfully..."));
		sessionMap.put("sucessMsg", "sucess");
		return "";
	}
	
	public String goBackToManageAppointments() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.remove("sucessMsg");
		return "ShowPatientAppointment.jsp?faces-redirect=true";
	}
}