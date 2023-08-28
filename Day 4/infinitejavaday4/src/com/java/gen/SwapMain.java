package com.java.gen;

public class SwapMain {
	public static void main(String[] args) {
		int x=10;
		int y = 15;
		GenericEx1 obj= new GenericEx1();
		obj.swap(x,y);
		
		double x1 = 10.5, y1=14.2;
		obj.swap(x1, y1);
		
		String x2="Rahul", y2="Raman";
		obj.swap(x2, y2);
	}

}
