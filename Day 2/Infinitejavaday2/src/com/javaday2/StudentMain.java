package com.javaday2;

public class StudentMain {

	public static void main(String[] args) {

		Student student = new Student();
		student.studentId = 1;
		student.name = "Rahul";
		student.course = Course.JAVA;
		student.cgp = 8.9;
		
		System.out.println("Student Id : "+student.studentId);
		System.out.println("Name : "+student.name);
		System.out.println("Course : "+ student.course);
		System.out.println("Cgpa : "+student.cgp);

	}

}
