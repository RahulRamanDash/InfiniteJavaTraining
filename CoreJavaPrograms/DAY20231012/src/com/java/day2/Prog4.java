package com.java.day2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Prog4 {
    public static void main(String[] args) {
    	// created a linked list
        LinkedList<String> names = new LinkedList<>();
        
        // Comment out the lines that add elements to get exception
        
        // names.add("Alice");
        // names.add("Bob");
        // names.add("Charlie");

        try {
        	// Attempting to remove from an empty list
            String removedName = names.removeFirst();
            // Print the removed element
            System.out.println("Removed: " + removedName);
        } catch (NoSuchElementException e) {
        	// this will throw the exception
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
