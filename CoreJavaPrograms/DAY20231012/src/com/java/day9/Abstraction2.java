package com.java.day9;

abstract class Bikes{  
	   Bikes(){
		   System.out.println("bike is created");
		}  
	   //abstract class contain both abstract and non abstract method 
	   abstract void run();
	   void changeGear(){
		   System.out.println("gear changed");
		}  
	 }
	//Creating a Child class which inherits Abstract class  
class Honda extends Bikes{  
	 void run(){
		 //we have to override all the abstract method present abstract class
		 System.out.println("running safely..");
	}  
}  
	
public class Abstraction2 {
	 public static void main(String args[]){  
		  Bikes obj = new Honda();  
		  obj.run();  
		  obj.changeGear();  
	 }  

}