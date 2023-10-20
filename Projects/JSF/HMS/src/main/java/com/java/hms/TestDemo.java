package com.java.hms;

public class TestDemo {
	public static void main(String[] args) {
		PatientMasterDaoImpl impl = new PatientMasterDaoImpl();
		System.out.println(impl.incrimentpatientId());
	}
}
