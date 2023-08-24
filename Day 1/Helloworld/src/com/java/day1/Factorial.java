package com.java.day1;

public class Factorial {

	public void fact(int number){
		int i =1, f=1;
		while(i<=number){
			f = f * i;
			i++;
		}
		System.out.println("Factorial of the Number is "+f);
		
	}
	public static void main(String[] args) {
		int number =5;
		new Factorial().fact(number);

	}

}
