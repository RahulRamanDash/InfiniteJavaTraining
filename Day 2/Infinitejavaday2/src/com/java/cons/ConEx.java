package com.java.cons;

public class ConEx {
	static{
		System.out.println("Static Cons is Running...");
	}
	ConEx(){
		System.out.println("Default Cons is running...");
	}

	public static void main(String[] args) {
		ConEx obj = new ConEx();

	}

}
