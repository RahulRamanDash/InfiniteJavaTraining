package com.java.day6;

// Base class representing a person
class Person {
    String name;
    int age;
    int salary;

    // Constructor for initializing name and age
    Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

// Subclass Student inheriting from Person
class Student extends Person {
    int rollNumber;
    
    // Constructor for initializing name, age, and roll number
    Student(String name, int age, int rollNumber, double salary) {
        // Call the superclass constructor
        super(name, age, (int) salary);
        this.rollNumber = rollNumber;
        
    }

    // Method to display student information
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Roll Number: " + rollNumber +", salary: "+salary);
    }
}

public class Prog1 {
    public static void main(String[] args) {
        // Create an array of Student objects
        Student[] students = {
            new Student("Alice", 18, 101, 10000.98),
            new Student("Bob", 19, 102, 20000.78),
            new Student("Charlie", 20, 103, 30000.56)
        };

        // Loop through the array and display student information
        for (Student student : students) {
            student.displayInfo();
        }
    }
}