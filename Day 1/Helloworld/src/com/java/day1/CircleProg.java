package com.java.day1;

public class CircleProg {
	public void calc( double radius){
		
		double area = 3.14 * radius * radius;
		double cirt = 2 * 3.14 * radius;
		
		System.out.println("Area of the circle is "+area);
		System.out.println("Circumference of the circle is "+cirt);

	}

	public static void main(String[] args) {
		double radius = 8.2;
		
		//while creating object
		CircleProg obj = new CircleProg();
		obj.calc(radius);
		
		//without creating object
		new CircleProg().calc(radius);

	}

}
