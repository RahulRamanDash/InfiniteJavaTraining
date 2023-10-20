package com.java.day8;

abstract class Bike{
	//abstract class abstract method only define method here
	  abstract void run();
	}
//inherited abstract class by Honda
class Honda4 extends Bike{
	//override method of super class implement here 
	void run(){
		System.out.println("running safely");
	}

}
public class Abstraction {
	public static void main(String args[]){  
		Bike obj = new Honda4();  
		obj.run();  
		}  
}