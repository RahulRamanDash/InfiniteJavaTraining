package com.java.esc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivEx {
	
	public static int division(int a , int b){
		return a/b;
		
	}

	public static void main(String[] args) {
		int a, b, c;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Two Numbers : ");
		try {
			a = sc.nextInt();
			b = sc.nextInt();
			
			System.out.println(division(a,b));
		}
		catch (ArithmeticException e){
			System.err.println("Number Can not devided by Zero.");
		}
		catch(InputMismatchException e){
			System.out.println("String can not be converted as String.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("Program From Infinite August 2023 Batch");
		}
		
	}
}
