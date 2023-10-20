package com.java.leaveproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class DateValidation {
    public static void main(String[] args) {
        // Get user input for the date in a specific format (e.g., "yyyy-MM-dd")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date in the format (yyyy-MM-dd): ");
        String inputDateStr = scanner.next();
        scanner.close();

        // Define the format you expect for the input date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Parse the input date string to a Date object
            Date inputDate = sdf.parse(inputDateStr);

            // Get yesterday's date
            Calendar cal = Calendar.getInstance();
            cal.setTime(inputDate);
            cal.add(Calendar.DATE, -1);
            Date yesterday = cal.getTime();

            // Format yesterday's date in the same format
            String yesterdayStr = sdf.format(yesterday);

            // Compare the input date with yesterday's date
            if (inputDateStr.equals(yesterdayStr)) {
                System.out.println("The input date is the same as yesterday's date.");
            } else {
                System.out.println("The input date is not the same as yesterday's date.");
            }
        } catch (java.text.ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
    }
}

