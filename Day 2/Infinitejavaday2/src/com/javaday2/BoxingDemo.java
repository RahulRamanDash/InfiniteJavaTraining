package com.javaday2;

public class BoxingDemo {

	public static void main(String[] args) {
		int num1 = 1;
		String str1 = "Rahul";
		double d1 = 12.5;
		
		
		Object obj1 = num1;
		Object obj2 = str1;
		Object obj3 = d1;
		

		int num2 = (Integer)num1;
		String str2 = (String)str1;
		double d2 = (double)d1;
		
		System.out.println(num2);
		System.out.println(str2);
		System.out.println(d2);
	}

}
