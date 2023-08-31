package com.java.task;

import java.util.Scanner;

public class NumberToWords {
    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };

    private static final String[] teens = {
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        String words = convertNumberToWords(number);
        System.out.println("Number in words: " + words);

        scanner.close();
    }

    public static String convertNumberToWords(long number) {
        if (number == 0) {
            return "Zero";
        }
        
        String words = "";
        int count = 0;
        
        while (number > 0) {
            if (number % 1000 != 0) {
                words = convertLessThanOneThousand((int) (number % 1000)) + thousands[count] + " " + words;
            }
            number /= 1000;
            count++;
        }
        
        return words.trim();
    }

    private static String convertLessThanOneThousand(int number) {
        if (number == 0) {
            return "";
        }
        
        if (number < 10) {
            return units[number] + " ";
        } else if (number < 20) {
            return teens[number - 10] + " ";
        } else if (number < 100) {
            return tens[number / 10] + " " + convertLessThanOneThousand(number % 10);
        } else {
            return units[number / 100] + " Hundred " + convertLessThanOneThousand(number % 100);
        }
    }
}
