package com.java.day2;

import java.util.ArrayList;
import java.util.List;

public class Prog2 {
	// this is the main method
	public static void main(String[] args) {
		// creating a list named "names"
		 List<String> names = new ArrayList<>();

	        // Add elements to the list
	        names.add("Alice");
	        names.add("Bob");
	        names.add("Charlie");

	        // go through the list and print elements
	        for (String name : names) {
	            System.out.println(name);
	        }
	}
}
