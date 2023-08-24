package com.java.day1;

public class EvenOdd {

	public void check(int number){
		if (number%2 == 0){
			System.out.println("It is an Even number...");
		}
		else{
			System.out.println("It is an Odd number...");
		}
	}
	public static void main(String[] args) {
		int number = 13;
		new EvenOdd().check(number);

	}

}
