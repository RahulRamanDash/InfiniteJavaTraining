package com.java.day5;

public class Prog1 {
    public static void main(String[] args) {
        // Create an array of integers
        int[] numbers = {1, 2, 3, 4, 5};

        // Calculate the sum of elements in the array
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        

        // Display the sum of the array elements
        System.out.println("Sum of elements in the array: " + sum);
    }
}
