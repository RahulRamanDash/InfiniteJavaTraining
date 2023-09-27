package com.java.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployTest {
	
	@Test
	public void testGettersAndSetters() {
		Employ employ = new Employ();
		employ.setEmpno(1);
		employ.setName("Rahul");
		employ.setGender(Gender.MALE);
		employ.setDept("Java");
		employ.setDesig("ASE");
		employ.setBasic(99424);
	
		assertEquals(1, employ.getEmpno());
		assertEquals("Rahul", employ.getName());
		assertEquals(Gender.MALE, employ.getGender());
		assertEquals("Java", employ.getDept());
		assertEquals("ASE", employ.getDesig());
		assertEquals(99424,employ.getBasic(),0);
	}

	@Test
	public void testConstructor() {
		Employ employ = new Employ();
		assertNotNull(employ);
		
		Employ emp = new Employ(1,"Rahul",Gender.MALE,"Java","ASE",99424);
		assertEquals(1, emp.getEmpno());
		assertEquals("Rahul", emp.getName());
		assertEquals(Gender.MALE, emp.getGender());
		assertEquals("Java", emp.getDept());
		assertEquals("ASE", emp.getDesig());
		assertEquals(99424,emp.getBasic(),0);
	}
	
	@Test
	public void testToString() {
		Employ emp = new Employ(1,"Rahul",Gender.MALE,"Java","ASE",99424);
		String result = "Employ [empno=1, name=Rahul, gender=MALE, dept=Java, desig=ASE, basic=99424.0]"; 
		assertEquals(result, emp.toString());
	}

}
