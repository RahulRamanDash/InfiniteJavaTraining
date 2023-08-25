package com.java.oops;

public class Main {

	public static void main(String[] args) {

		Employ s1 = new Employ(1,"Rahul",54684);
		Employ s2 = new Employ(1,"Rahul",54684);
		Employ s3 = s2;
		
		System.out.println(s1==s2);
		System.out.println(s2==s3);
		
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));

	}

}
