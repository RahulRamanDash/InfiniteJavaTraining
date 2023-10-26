package com.java.day3;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class Prog3 {
    public static void main(String[] args) {
        int count = 0;
        while (count < 5) {
            try {
                if (count != 3) {
                	System.out.println("Iteration: " + count);
                }else {                	
                	throw new MyException("Custom exception example");
                }
            } catch (MyException e) {
                System.err.println("Error: " + e.getMessage());
            }
            count++;
        }
    }
}

