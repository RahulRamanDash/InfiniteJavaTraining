package com.java.day3;

class MathUtils {
    int add(int a, int b) { // Method to add two integers
        return a + b;
    }

    double add(double a, double b) { // Method to add two doubles
        return a + b;
    }

    String add(String a, String b) { // Method to concatenate two strings
        return a + b;
    }
}

public class MethodOverloadingExample {
    public static void main(String[] args) {
        MathUtils math = new MathUtils(); // Create an instance of MathUtils

        int result1 = math.add(5, 3); // Calls the add method for integers
        double result2 = math.add(2.5, 3.7); // Calls the add method for doubles
        String result3 = math.add("Hello, ", "World!"); // Calls the add method for strings

        System.out.println("Result 1: " + result1); // Print the result of the first addition
        System.out.println("Result 2: " + result2); // Print the result of the second addition
        System.out.println("Result 3: " + result3); // Print the concatenated string
    }
}
