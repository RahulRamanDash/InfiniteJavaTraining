package com.java.day1;

import java.util.HashSet;
import java.util.Set;

public class Prog3 {
	    public static void main(String[] args) {
	        // Create a set of integers
	        Set<Integer> numbers = new HashSet<>();

	        // Add elements to the set
	        numbers.add(1);
	        numbers.add(2);
	        numbers.add(3);
	        numbers.add(2); // Duplicates are not allowed

	        // Iterate and print elements
	        for (int number : numbers) {
	            System.out.println(number);
	        }
	}

}
