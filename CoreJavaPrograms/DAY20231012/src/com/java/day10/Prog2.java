package com.java.day10;

import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    List<Integer> grades = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}

public class Prog2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Alice");
        student1.addGrade(85);
        student1.addGrade(90);
        Student student2 = new Student("Bob");
        student2.addGrade(75);
        student2.addGrade(80);
        students.add(student1);
        students.add(student2);

        for (Student student : students) {
            double average = student.calculateAverage();
            System.out.println(student.name + "'s average grade: " + average);
        }
    }
}
