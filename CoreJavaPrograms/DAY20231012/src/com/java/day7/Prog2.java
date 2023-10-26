package com.java.day7;

// Abstract base class representing a geometric shape
abstract class Shape {
    // Abstract method to calculate the area of a shape
    abstract double calculateArea();
}

// Subclass Circle inheriting from Shape
class Circle extends Shape {
    double radius;

    // Constructor to initialize the radius
    Circle(double radius) {
        this.radius = radius;
    }

    // Override the abstract method to calculate the area of a circle
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass Rectangle inheriting from Shape
class Rectangle extends Shape {
    double width;
    double height;

    // Constructor to initialize the width and height
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Override the abstract method to calculate the area of a rectangle
    @Override
    double calculateArea() {
        return width * height;
    }
}

public class Prog2 {
    public static void main(String[] args) {
        // Create an array of Shape objects, including circles and rectangles
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0)
        };

        // Loop through the array and calculate and display the area of each shape
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }
}
