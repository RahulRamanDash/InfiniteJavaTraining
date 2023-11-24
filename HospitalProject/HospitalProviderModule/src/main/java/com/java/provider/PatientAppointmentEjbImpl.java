package com.java.provider;

import java.util.Map;

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
		System.out.println("update ejb working");
		PatientAppointmentBeanRemote remote =
				RemoteHelper.lookupRemoteStatelessEmploy();
		remote.updateAppointment(appointment);
		return "ShowPatientAppointmentNew.jsp?faces-redirect=true";
	}
}
