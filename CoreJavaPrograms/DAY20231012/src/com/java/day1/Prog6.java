package com.java.day1;

public class Prog6 {

    // Define a method that takes two integer parameters
    static int plusMethod(int x, int y) {
        return x + y;
    }

    // method that takes two double parameters and returns double value
    static double plusMethod(double x, double y) {
        return x + y;
    }
    int sum(int x, int y) {
    	return x+y;
    }

    public static void main(String[] args) {
        // Call the plusMethod with integer arguments (8 and 5) and store the result in myNum1
        int myNum1 = plusMethod(8, 5);

        // Call the plusMethod with double arguments (4.3 and 6.26) and store the result in myNum2
        double myNum2 = plusMethod(4.3, 6.26);

        // Print the result of the integer addition
        System.out.println("int: " + myNum1);

        // Print the result of the double addition
        System.out.println("double: " + myNum2);
        
        
        Prog6 obj = new Prog6();
        System.out.println(obj.sum(6,4));
    }
}
