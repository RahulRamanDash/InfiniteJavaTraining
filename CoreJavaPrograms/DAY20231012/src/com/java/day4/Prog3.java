package com.java.day4;

import java.util.ArrayList;

public class Prog3 {
    public static void main(String[] args) {
        // Create an ArrayList to store a list of integers
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        // Call the sumArrayList method to calculate the sum of elements in the ArrayList
        int sum = sumArrayList(numbers);
        
        // Display the sum of elements in the ArrayList
        System.out.println("Sum of elements in the ArrayList: " + sum);
    }

    // This method calculates the sum of integers in an ArrayList
    static int sumArrayList(ArrayList<Integer> list) {
        int sum = 0;

        // Iterate through the ArrayList and sum up all the integers
        for (int num : list) {
            sum += num;
        }

        // Return the total sum
        return sum;
    }
}