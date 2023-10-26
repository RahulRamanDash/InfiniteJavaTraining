package com.java.jsf;

public class Dummy {

	public static void main(String[] args) {
		//System.out.println(new EmployDAOImpl().showEmployDao());
		EmployDAOImpl impl = new EmployDAOImpl();
		System.out.println(impl.countRows());
	}
}
