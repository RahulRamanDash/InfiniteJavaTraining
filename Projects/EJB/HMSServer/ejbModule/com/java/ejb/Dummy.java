package com.java.ejb;

import java.sql.SQLException;

public class Dummy {
	public static void main(String[] args) {
		PatientMasterDaoImpl dao = new PatientMasterDaoImpl();
//		PatientMaster patient = new PatientMaster();
//		patient.setPid("1");
//		 patient.setName("Rahul");
//		 patient.setWeight(23);
//		 patient.setGender("m");
//		 patient.setAddress("balangir");
//		 patient.setPhoneNo("7735509631");
//			patient.setDisease("coma");
//			patient.setDoctorId("D0001");
		try {
			System.out.println(dao.getpatientIdDao());
			//System.out.println(dao.addPatientDao(patient));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
