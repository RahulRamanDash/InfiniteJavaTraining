package com.javanewfetures;

public class Greeting {
	public static void main(String[] args) {
		Igreeting obj = () -> {
			System.out.println("Hello...");
		};
		obj.greetMe();
	}

}
