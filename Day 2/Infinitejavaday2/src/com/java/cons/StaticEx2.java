package com.java.cons;

public class StaticEx2 {
	static int count;
	public void show(){
		count++;
		System.out.println("Value of count is : "+count);
	}

	public static void main(String[] args) {
		
		
		StaticEx2 obj1 = new StaticEx2();
		StaticEx2 obj2 = new StaticEx2();
		StaticEx2 obj3 = new StaticEx2();
		
		obj1.show();
		obj2.show();
		obj3.show();

	}

}
