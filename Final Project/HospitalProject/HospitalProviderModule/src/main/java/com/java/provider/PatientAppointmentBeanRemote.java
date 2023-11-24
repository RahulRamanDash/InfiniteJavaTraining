package com.java.provider;

import javax.ejb.Remote;

@Remote
public interface PatientAppointmentBeanRemote {
	public PatientAppointment searchAppointment(String appointmentId);
	public String updateAppointment(PatientAppointment appointment);
}
