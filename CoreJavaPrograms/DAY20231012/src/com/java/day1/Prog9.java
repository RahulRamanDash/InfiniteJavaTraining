package com.java.day1;

import java.util.ArrayList;
import java.util.Iterator;

public class Prog9 {
	 public static void main(String[] args) {

		    // Make a collection
		    ArrayList<String> cars = new ArrayList<String>();
		    
		    // add elements to list
		    cars.add("TATA");
		    cars.add("JCB");
		    cars.add("BMW");
		    cars.add("AUDI");

		    // Get the iterator
		    Iterator<String> it = cars.iterator();

		    it.remove();
		    // Print the first item
		    System.out.println(it.next());
		    // check if the next value is present or not
		    // returns true if next value is presernt
		    System.out.println(it.hasNext());
		    // prints the menory location
		    System.out.println(it.hashCode());
		    // checks if two list's are same or not
		    System.out.println(it.equals(it));
		    
		    for(String car :cars) {
		    	System.out.println(car);
		    }
		    
		    
		  }
}
