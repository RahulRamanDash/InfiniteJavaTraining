package com.java.day8;

public class PerfectSquare {

    // Function to check if a given number is a perfect square
    static boolean isPerfectSquare(int x) {
        if (x >= 0) {
            // Calculate the square root of 'x'
            int sr = (int) Math.sqrt(x);
            
            // Check if the square of the square root is equal to 'x' (a perfect square)
            return ((sr * sr) == x);
        }
        return false; // If 'x' is negative, it can't be a perfect square
    }

    public static void main(String[] args) {
        int x = 84;

        // Check if 'x' is a perfect square and print the result
        if (isPerfectSquare(x))
            System.out.print("True"); // 'x' is a perfect square
        else
            System.out.print("False"); // 'x' is not a perfect square
    }
}
