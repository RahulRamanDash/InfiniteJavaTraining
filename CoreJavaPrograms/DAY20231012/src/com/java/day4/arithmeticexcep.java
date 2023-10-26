package com.java.day4;

public class arithmeticexcep {
    public static void main(String[] args) {
        int dividend = 10; // Define an integer variable "dividend" and assign the value 10 to it.
        int divisor = 0;  // Define an integer variable "divisor" and assign the value 0 to it.
        try {
            int result = dividend / divisor; // Attempt to divide "dividend" by "divisor," which will throw an ArithmeticException if "divisor" is 0.
            System.out.println("Result: " + result); // This line will not be reached if an exception is thrown.
        } catch (ArithmeticException e) {
            // Catch and handle the ArithmeticException if it occurs.
            System.out.println("Error: " + e.getMessage()); // Print an error message along with the exception message.
        }
    }
}

