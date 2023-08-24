package com.java.day1;

public class StringOperation {
	public void show(){
		String str ="my name is rahul raman dash";
		System.out.println("length of the string is: "+str.length());
		System.out.println("First Occurrence of char: "+str.indexOf("a"));
		System.out.println("Char at 4th position is: "+str.charAt(4));
		System.out.println("Upper case: "+str.toUpperCase());
		System.out.println("Lower case: "+str.toLowerCase());
		
		String s1="NotToday";
		String s2 = "Hello";
		String s3 = "NotToday";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
	}

	public static void main(String[] args) {
		new StringOperation().show();

	}

}
