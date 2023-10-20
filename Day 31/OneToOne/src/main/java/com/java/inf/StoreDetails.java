package com.java.inf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StoreDetails {

	public static void main(String[] args) {
		SessionFactory factory =  new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction t= session.beginTransaction();
		
		Employee e = new Employee();
		e.setEmployeeId(1);
		e.setName("Rahul");
		e.setEmail("rahul@mail.com");
		session.save(e);
		
		Address address = new Address();
		address.setAddressLine1("37-115/3, Sree Colony");
		address.setCity("Hydrabad");
		address.setCountry("India");
		address.setPincode(767344);
		e.setAddress(address);
		address.setEmployee(e);
		session.save(address);
		
		t.commit();
		session.close();
		System.out.println("Success");
	}

}
