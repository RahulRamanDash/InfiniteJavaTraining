package com.java.provider;

import java.text.ParseException;
import java.util.List;

public interface PatientAppointmentDAO {
	List<PatientAppointment> searchPatientAppointmentDao(int firstRow, int rowCount, String searchValue) throws ParseException;
}
