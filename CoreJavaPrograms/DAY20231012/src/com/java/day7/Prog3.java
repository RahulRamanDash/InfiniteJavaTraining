package com.java.day7;

// Base class representing an Employee
class Employee {
    String name;

    // Constructor for initializing the employee's name
    Employee(String name) {
        this.name = name;
    }

    // Method to calculate the salary (to be overridden by subclasses)
    double calculateSalary() {
        return 0.0;
    }
}

// Subclass Manager inheriting from Employee
class Manager extends Employee {
    // Constructor for initializing the manager's name
    Manager(String name) {
        super(name);
    }

    // Override the calculateSalary method for managers
    @Override
    double calculateSalary() {
        return 5000.0;
    }
}

// Subclass Worker inheriting from Employee
class Worker extends Employee {
    // Constructor for initializing the worker's name
    Worker(String name) {
        super(name);
    }

    // Override the calculateSalary method for workers
    @Override
    double calculateSalary() {
        return 2000.0;
    }
}

public class Prog3 {
    public static void main(String[] args) {
        // Create an array of Employee objects, including managers and workers
        Employee[] employees = {new Manager("Alice"), new Worker("Bob")};

        // Loop through the array and display each employee's name and salary
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.name + ", Salary: " + employee.calculateSalary());
        }
    }
}
