package com.java.task;

import java.util.Scanner;

public class Multiplication {
	
	  public static int[] multi(String num1, String num2) {
	        int len1 = num1.length();
	        int len2 = num2.length();
	        int[] result = new int[len1 + len2];

	        for (int i = len1 - 1; i >= 0; i--) {
	            for (int j = len2 - 1; j >= 0; j--) {
	                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
	                int sum = product + result[i + j + 1];

	                result[i + j + 1] = sum % 10;
	                result[i + j] += sum / 10;
	            }
	        }

	        return result;
	    }
	  
	  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Two numbers: ");
        String number1 = sc.nextLine();
        String number2 = sc.nextLine();

        int[] result = multi(number1, number2);
        
        System.out.print("Result: ");
        for (int digit : result) {
            System.out.println(digit);
        }
    }

  
}
