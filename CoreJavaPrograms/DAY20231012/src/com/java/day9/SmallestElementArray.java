package com.java.day9;

import java.util.Scanner;

public class SmallestElementArray {
    public static void main(String args[]) {

        // Create an integer array with some values
        int arr[] = {12, 13, 1, 10, 34, 10};

        // Initialize variables to store the largest and smallest elements
        int largest = arr[0], smallest = arr[0];

        // Iterate through the array to find the largest and smallest elements
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is smaller than the current 'smallest'
            if (smallest > arr[i])
                smallest = arr[i];
            
            // Check if the curret element is larger than the current 'largest'
            if (largest < arr[i])
                largest = arr[i];
        }

        // Print the smallest and largest elements in the array
        System.out.println("Smallest element in the array: " + smallest);
        System.out.println("Largest element in the array: " + largest);
    }
}
