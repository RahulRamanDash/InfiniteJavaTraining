package com.java.day1;

public class Prog7 {
	public static void main(String[] args) {
		int number = 5;
		// Change this to the number for which you want to calculate the factorial
		long result = factorial(number);
		// Call the factorial method to calculate the factorial
		System.out.println("Factorial of " + number + " is " + result); 
		// Print the result
	}

	// Recursive method to calculate the factorial of a number
	static long factorial(int n) {
		if (n == 0) {
			return 1;
			// Base case: 0! is 1
		} else {
			return n * factorial(n - 1);
		}
	}

}