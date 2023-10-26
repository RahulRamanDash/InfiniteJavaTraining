package com.java.day3;

import java.util.HashMap;
import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) {
    	// created a map and put some key, value pairs
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("CPU", "Central Processing Unit");
        dictionary.put("RAM", "Random Access Memory");
        dictionary.put("GPU", "Graphics Processing Unit");
        dictionary.put("HTTP", "Hypertext Transfer Protocol");
        dictionary.put("HTTPS", "Hypertext Transfer Protocol Secure");
        dictionary.put("URL", "Uniform Resource Locator");
        dictionary.put("HTML", "Hypertext Markup Language");
        dictionary.put("CSS", "Cascading Style Sheets");
        dictionary.put("API", "Application Programming Interface");
        dictionary.put("DNS", "Domain Name System");
        dictionary.put("SQL", "Structured Query Language");
        dictionary.put("IDE", "Integrated Development Environment");
        dictionary.put("OOP", "Object-Oriented Programming");
        dictionary.put("GUI", "Graphical User Interface");
        
        // Created a object of scanner classs to take input from the users
        Scanner scanner = new Scanner(System.in);

        // while loop to show options tille the user exits the program in a loop
        while (true) {
            // Display menu options
            System.out.println("Dictionary Menu:");
            System.out.println("1. Add a word and its Full-Form");
            System.out.println("2. Search for a word");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice=0;
            	// take the option value from the user
                choice = scanner.nextInt();
             
            // this is used to take the option value and give desired output
            switch (choice) {
                case 1:
                    // Add a word and its definition
                    System.out.print("Enter the word: ");
                    String word = scanner.next();
                    System.out.print("Enter the Full-Form: ");
                    String definition = scanner.next();
                    dictionary.put(word, definition);
                    System.out.println("Word added to the dictionary.");
                    break;

                case 2:
                    // Search for a word
                    System.out.print("Enter the word to search: ");
                    word = scanner.next();
                    // this conditional block will check if the key is present or not
                    if (dictionary.containsKey(word)) {
                        System.out.println(word + ": " + dictionary.get(word));
                    } else {
                        System.out.println("Word not found in the dictionary.");
                    }
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting the dictionary program.");

                // if nothing is not matching then default will run
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
