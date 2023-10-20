package com.java.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryProgram {
    public static void main(String[] args) {
        // Create a HashMap to store words and their meanings
        Map<String, String> dictionary = new HashMap<>();

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("\nDictionary Program Menu:");
            System.out.println("1. Look up a word");
            System.out.println("2. Add a word and its meaning");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Look up a word
                    System.out.print("Enter a word to look up: ");
                    String wordToLookup = scanner.nextLine();
                    String meaning = dictionary.get(wordToLookup);
                    if (meaning != null) {
                        System.out.println("Meaning: " + meaning);
                    } else {
                        System.out.println("Word not found in the dictionary.");
                    }
                    break;

                case 2:
                    // Add a word and its meaning
                    System.out.print("Enter a word: ");
                    String newWord = scanner.nextLine();
                    System.out.print("Enter its meaning: ");
                    String newMeaning = scanner.nextLine();
                    dictionary.put(newWord, newMeaning);
                    System.out.println("Word and meaning added to the dictionary.");
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting the dictionary program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
