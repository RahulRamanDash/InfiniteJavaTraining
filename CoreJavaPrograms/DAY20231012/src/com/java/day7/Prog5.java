package com.java.day7;

import java.util.Scanner;
import java.util.Random;

// Class representing a simple guessing game
class Game {
    private int targetNumber; // The number to be guessed
    private int maxAttempts;   // The maximum number of attempts allowed
    private int attempts;      // The current number of attempts
    
    // Constructor to initialize the game with a maximum range and attempts
    public Game(int maxRange, int maxAttempts) {
        Random random = new Random();
        targetNumber = random.nextInt(maxRange) + 1; // Generate a random target number
        this.maxAttempts = maxAttempts;               // Set the maximum attempts
        attempts = 0;                                // Initialize the attempts
    }
    // Add

    // Method to make a guess and check if it's correct
    public boolean makeGuess(int guess) {
        attempts++; // Increment the attempts count
        if (guess == targetNumber) { // Check if the guess is correct
            System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
            System.out.println("It took you " + attempts + " attempts.");
            return true; // The game is over
        } else {
            if (guess < targetNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }

            if (attempts >= maxAttempts) {
                System.out.println("You've run out of attempts. The correct number was: " + targetNumber);
                return true; // The game is over, and the correct number is revealed
            }
            return false; // The game continues
        }
    }
}

public class Prog5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxRange = 10;
        int maxAttempts = 10;

        Game game = new Game(maxRange, maxAttempts); // Create a new game
        boolean isGameOver = false; // Initialize the game state

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between 1 and " + maxRange + ". Try to guess it.");

        while (!isGameOver) { // Continue the game until it's over
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt(); // Read the player's guess
            isGameOver = game.makeGuess(guess); // Make a guess and check if the game is over
        }

        System.out.println("Thanks for playing!"); // Display a message when the game ends
    }
}
