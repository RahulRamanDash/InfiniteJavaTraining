package com.java.day9;

public class SingleTonEx {
	public static void main(String[] args) {
		Calculation calc1 = Calculation.getInstance();
		System.out.println(calc1.sum(12,5));
	
		Calculation calc2 = Calculation.getInstance();
		System.out.println(calc2.sub(12,5));

	
	}
}
