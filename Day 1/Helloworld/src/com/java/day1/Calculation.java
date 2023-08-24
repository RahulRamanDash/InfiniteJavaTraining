package com.java.day1;

public class Calculation {
	public void calc(int a, int b){
		int c = a+b;
		System.out.println("Sum is "+c);
		int d = a-b;
		System.out.println("Sub is "+d);
		int e = a*b;
		System.out.println("Mult is "+e);
		
	}

	public static void main(String[] args) {
		int a, b;
		a = 5;
		b = 4;
		Calculation obj = new Calculation();
		obj.calc(a, b);

	}

}
