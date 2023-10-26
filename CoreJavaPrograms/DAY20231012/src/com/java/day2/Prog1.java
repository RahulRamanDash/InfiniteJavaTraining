package com.java.day2;
// 
public class Prog1 {
// class name is prog1 which has public access specifier
	public void sayHello() {
		// sayhello method was created
	System.out.println("Hello World!");
	//return "Hello";
	// this will print hello world on console
}

	public static void main(String[] args) {
		// this is the main method
		Prog1 obj = new Prog1();
		// creating a object
		obj.sayHello();
		// calling the method using the object
	}

}
