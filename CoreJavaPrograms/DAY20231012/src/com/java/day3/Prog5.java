package com.java.day3; 

class GeometricCalculator {
    public double calculateArea(double side) {
    	// Method to calculate the area of a square, taking a single parameter (side length).
        if (side < 0) {
        	// Check if the side length is negative.
            throw new IllegalArgumentException("Side length cannot be negative.");
            // Throw an exception with a custom error message.
        }
        return side * side; 
        // Calculate and return the area of the square.
    }

    // Method to calculate the area of a rectangle, taking two parameters (length and width).
    public double calculateArea(double length, double width) {
    	// Check if either the length or width is negative.
        if (length < 0 || width < 0) {
        	// Throw an exception with a custom error message.
            throw new IllegalArgumentException("Length and width cannot be negative.");
        }
        // Calculate and return the area of the rectangle.
        return length * width;
    }
} // End of the GeometricCalculator class definition.

// Start of the Prog5 class definition.
public class Prog5 {
	// Main method, the entry point of the program.
    public static void main(String[] args) {
    	// Create an instance of the GeometricCalculator class.
        GeometricCalculator calculator = new GeometricCalculator();

        // Start of a try block to handle exceptions.
        try {
        	// Calculate the area of a square with a side length of 4.0.
            double squareArea = calculator.calculateArea(4.0);
            // Calculate the area of a rectangle with a length of 3.0 and a width of 5.0.
            double rectangleArea = calculator.calculateArea(3.0, 5.0); 

            // Print the area of the square.
            System.out.println("Square Area: " + squareArea);
            // Print the area of the rectangle.
            System.out.println("Rectangle Area: " + rectangleArea);

            // Catch and handle IllegalArgumentException if it's thrown.
        } catch (IllegalArgumentException e) { 
        	// Print an error message to the standard error stream.
            System.err.println("Error: " + e.getMessage()); 
        }
    }
} // End of the Prog5 class definition.
