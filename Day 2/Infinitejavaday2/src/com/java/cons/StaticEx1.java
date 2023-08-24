package com.java.cons;

public class StaticEx1 {
	static int count;
	public void incriment(){
		count++;
	}
	public void show(){
		System.out.println("Value of count is : "+count);
	}

	public static void main(String[] args) {
		StaticEx1 obj = new StaticEx1();
		obj.incriment();
		obj.show();
		obj.incriment();
		obj.show();

	}

}
