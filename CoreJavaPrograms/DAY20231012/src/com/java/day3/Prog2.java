package com.java.day3;

import java.util.Scanner;

public class Prog2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // This will run for ever
        while (true) {
            try {
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                System.out.println("You entered: " + number);
            // if the user enter any othor value then int then it will throw an error
            } catch (java.util.InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                // if the exception comes breck is used to stop the program
                break;
            }
        }
    }
}

