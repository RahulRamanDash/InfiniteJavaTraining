package com.java.day1;

public class Demo {

	public static void main(String[] args) {
		
		Data obj = new Data();
		
		obj.sayHello();
		obj.company();
		
		String s1 = "Hello";
		String s2 = "World";
		String s3 = "World";
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());

	}

}
