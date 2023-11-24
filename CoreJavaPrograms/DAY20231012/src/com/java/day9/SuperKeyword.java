package com.java.day9;

class Animal{
	public void printColor1() {		
		System.out.println("Black");
	}
}

// Class Animal inherit using extends class
class Dog extends Animal{
	// Crate a method
	public void printColor2() {
		//Print the color from Animal class through super keyword
		System.out.println("Blue");
	}
}

public class SuperKeyword {
	public static void main(String[] args) {
		// Create a object name d
		Dog d = new Dog();
		// Call the method using object
		d.printColor2();
		
		Animal obj1 = new Animal();
//		((Dog) obj1).printColor();
		
		
		Animal obj = new Dog();
		((Dog) obj).printColor2();
		
		
	}
}