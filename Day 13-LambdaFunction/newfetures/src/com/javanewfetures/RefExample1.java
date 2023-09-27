package com.javanewfetures;


public class RefExample1 {

	void display() {
		System.out.println("Example of Functional Interface");
	}
	public static void main(String[] args) {
		RefExample1 obj = new RefExample1();
		ImethodRef1 m1 = obj::display;
		m1.show();
	}
}
