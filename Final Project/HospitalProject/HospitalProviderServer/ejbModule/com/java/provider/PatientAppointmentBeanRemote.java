package com.java.provider;

import javax.ejb.Remote;

@Remote
public interface PatientAppointmentBeanRemote {
	PatientAppointment searchAppointment(String appointmentId);
	String updateAppointment(PatientAppointment appointment);
}
