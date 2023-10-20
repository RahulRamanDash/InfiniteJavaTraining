package com.java.day4;

import java.util.HashSet;
import java.util.Iterator;

public class Prog2 {
    public static void main(String[] args) {
        // Create a HashSet of integers
        HashSet<Integer> numbers = new HashSet<>();

        // Add elements to the Set
        numbers.add(5);
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);

        // Display the original set
        System.out.println("Original Set: " + numbers);

        // Check if an element exists in the set
        int elementToCheck = 10;
        if (numbers.contains(elementToCheck)) {
            System.out.println(elementToCheck + " exists in the Set.");
        } else {
            System.out.println(elementToCheck + " does not exist in the Set.");
        }

        // Remove an element from the set
        int elementToRemove = 15;
        numbers.remove(elementToRemove);
        System.out.println("Set after removing " + elementToRemove + ": " + numbers);

        // Iterate through the set
        System.out.print("Iterating through the Set: ");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            System.out.print(num + " ");
        }

        // Size of the set
        System.out.println("\nSize of the Set: " + numbers.size());

        // Clear the set
        numbers.clear();
        System.out.println("Set after clearing: " + numbers);
    }
}
