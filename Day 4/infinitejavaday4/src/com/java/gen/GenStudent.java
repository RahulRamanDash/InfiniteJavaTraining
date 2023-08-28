package com.java.gen;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;



public class GenStudent {
	public static void main(String[] args) {
		Comparator c = new SortByName();
		SortedSet<Student>students = new TreeSet<Student>(c);
		
//		Comparator c = new SortByCgp();
//		SortedSet<Student>students = new TreeSet<Student>(c);
//		
		
		students.add(new Student(1,"Rahul","Odisha",9.0));
		students.add(new Student(2,"Rohan","Odisha",8.5));
		students.add(new Student(3,"Ganesh","Hydrabad",8.0));
		students.add(new Student(4,"Mukesh","Bihar",7.5));
		students.add(new Student(5,"Abhishak","Odisha",9.5));

		
		System.out.println("Sorted Data ");
		
		for(Object obj: students){
			Student student = (Student)obj;
			System.out.println(student);
		}
	}

}
