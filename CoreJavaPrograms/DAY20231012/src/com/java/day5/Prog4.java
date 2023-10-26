package com.java.day5;

import java.util.ArrayList;
import java.util.HashSet;

public class Prog4 {
    public static void main(String[] args) {
        // Create an ArrayList to store a list of names
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice");
        names.add("Charlie");
        
        // Call the removeDuplicates method to remove duplicates from the ArrayList
        ArrayList<String> uniqueNames = removeDuplicates(names);
        
        // Display the unique names in the ArrayList
        System.out.println("Unique names in the ArrayList: " + uniqueNames);
    }

    // This method removes duplicate elements from an ArrayList of strings
    static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        // Create a HashSet to eliminate duplicates
        HashSet<String> set = new HashSet<>(list);
        
        // Convert the HashSet back to an ArrayList to maintain the order
        return new ArrayList<>(set);
    }
}
