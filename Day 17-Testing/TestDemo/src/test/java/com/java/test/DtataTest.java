package com.java.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DtataTest {
	static Data data;
	@BeforeClass
	public static void startUp() {
		data = new Data();
		System.out.println("Object Created...");
	}
	@Before
	public void showsMessage() {
		System.out.println("Test Case Execution Started...");
	}
	@After
	public void showeMessage() {
		System.out.println("Test Case Execution Ended...");
	}
	@AfterClass
	public static void cleanup() {
		data =null;
		System.out.println("Resource Deallocated...");
	}
	
	@Test
	public void testevenOdd() {
		//Data data = new Data();
		assertTrue(data.evenOdd(6));
		assertFalse(data.evenOdd(5));
	}

	@Test
	public void testMapEx() {
		//Data data = new Data();
		assertNotNull(data.mapEx("Ganesh"));
		assertNull(data.mapEx("Sonali"));
	}
	@Test
	public void testNull() {
		Data obj = null;
		assertNull(obj);
	}
	@Test
	public void testArray() {
		int[] a = new int[] {1,2,3,4,5};
		int[] b = new int[] {1,2,3,4,5};
		assertArrayEquals(a, b);
	}

	@Test
	public void testSum3() {
//		Data data = new Data();
		assertEquals(5, data.max3(5, 2, 3));
		assertEquals(5, data.max3(2, 5, 3));
		assertEquals(5, data.max3(3, 2, 5));
	}
	@Test
	public void testSum() {
//		Data obj = new Data();
		assertEquals(5, data.sum(2, 3));
	}
	
	@Test
	public void testSayHello() {
		//Data obj = new Data();
		assertEquals("Welcome to Junit Programming....", data.sayHello());
		
	}
	@Test
	public void test() {
		assertEquals("HI","HI","HI");
	}
	
	
}
