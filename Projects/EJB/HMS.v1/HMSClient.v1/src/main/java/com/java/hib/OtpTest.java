package com.java.hib;

public class OtpTest {
	public static void main(String[] args) {
		PatientMasterDaoImpl dao = new PatientMasterDaoImpl();
		PatientMaster patient = new PatientMaster();
		patient.setUsername("rahul");
		patient.setOtpString("123456");
		System.out.println(dao.searchPatientByUsername("rahul"));
	}
}
