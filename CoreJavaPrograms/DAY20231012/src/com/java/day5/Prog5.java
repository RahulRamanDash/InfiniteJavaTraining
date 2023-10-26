package com.java.day5;

import java.util.ArrayList;

public class Prog5 {
    public static void main(String[] args) {
        // Create an ArrayList to store a list of numbers with decimal points
        ArrayList<Double> numbers = new ArrayList<>();

        // Add three numbers to the ArrayList
        numbers.add(10.5);
        numbers.add(15.3);
        numbers.add(20.1);

        // Calculate the average of the elements in the ArrayList
        double average = calculateAverage(numbers);

        // Display the result to the console
        System.out.println("Average of elements in the ArrayList: " + average);
    }

    // This method calculates the average of the numbers in the ArrayList
    static double calculateAverage(ArrayList<Double> list) {
        double sum = 0;

        // Iterate through the ArrayList and sum up all the numbers
        for (double num : list) {
            sum += num;
        }

        // Calculate the average by dividing the sum by the number of elements
        return sum / list.size();
    }
}
