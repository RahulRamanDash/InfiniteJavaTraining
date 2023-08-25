package com.java.oops;

public class Exam {
	public static void main(String[] args) {
		Student student = new Student();
		student.setId(1);
		student.setName(" Rahul raman ");
		
		
		GoogleForum form = new GoogleForum();
		form.setName(student.getName());
		form.mcqTest(student.getName());
		form.question();
		
		
		Hackthon hackthon = new Hackthon();
		hackthon.setLanguage(student.getName());
		hackthon.setLimit();
	}

}
