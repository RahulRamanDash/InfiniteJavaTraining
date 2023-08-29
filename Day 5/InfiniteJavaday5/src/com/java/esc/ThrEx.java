package com.java.esc;

import java.util.Scanner;

public class ThrEx {
	public void show(int n){
		if(n<0){
			throw new ArithmeticException("Negetive no is not Allowed...");
		}else if(n==0){
			System.out.println("Zero is a Invelid Value...");
		}else{
			System.out.println("N value is "+n);
		}
		
	}
	public static void main(String[] args) {
		int n;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a Number ");
		n = sc.nextInt();
		
		ThrEx obj = new ThrEx();
		try {
			obj.show(n);
		} 
		catch (ArithmeticException e){
			System.err.println(e.getMessage());
		}
		catch (NumberFormatException e){
			System.err.println(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
