package com.java.day1;

//Base class (parent class)
class Animal {
 String name;

 public Animal(String name) {
     this.name = name;
 }

 public void speak() {
     System.out.println(name + " makes a sound");
 }
}

//Derived class (child class)
class Dog extends Animal {
 public Dog(String name) {
     super(name); // Call the constructor of the base class
 }

 public void speak() {
     System.out.println(name + " barks");
 }
}

public class Prog8 {
 public static void main(String[] args) {
     // Create an instance of the base class
     Animal genericAnimal = new Animal("Generic Animal");
     genericAnimal.speak();

     // Create an instance of the derived class
     Dog myDog = new Dog("Buddy");
     myDog.speak();
 }
}
