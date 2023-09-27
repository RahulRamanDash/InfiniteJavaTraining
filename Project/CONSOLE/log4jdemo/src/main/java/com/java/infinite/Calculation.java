package com.java.infinite;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class Calculation {
	public static final Logger Log = Logger.getLogger("com.java.infinite.Calculation");
	public static void main(String[] args) {
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Two Numbers : ");
		try {
			a = sc.nextInt();
			b = sc.nextInt();
			c=a/b;
			System.out.println("Division is "+c);
			Log.info("Program Executed with no Exception");
		} 	catch (ArithmeticException e) {
			System.out.println("Division by zero not posible");
			Log.error("Custom error Devision by Zero not posible");
		}
		catch (InputMismatchException e) {
			System.out.println("String can not be converted as integer");
			Log.error("Custom error String can not be converted as integer");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
