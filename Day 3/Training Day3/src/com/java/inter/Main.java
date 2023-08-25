package com.java.inter;

public class Main implements One,Two,Three{
	
	@Override
	public void show() {
		
		System.out.println("This is The Main Method..");
		
	}

	
	public static void main(String[] args) {
		Main obj = new Main();
		obj.show(); 
		

	}

	
}
