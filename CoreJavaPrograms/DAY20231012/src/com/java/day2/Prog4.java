package com.java.day2;

public class Prog4 {
    public static void main(String[] args) {
        // Declare an array of integers with a fixed size of 5
        int[] numbers = new int[5];

        // Initialize the array with some values
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Access and print the values in the array
        System.out.println("Array elements:");

        // Use a for loop to iterate through the array and print each element
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
    }
}
