package com.javaday2;

public class EnumExp2 {
	public static void main(String[] args) {
		String str = "JAVA";
		String type = str.getClass().getSimpleName();
		System.out.println(type);
		
		Course course = Course.valueOf(str);
		
		String type1 = course.getClass().getSimpleName();
		
		System.out.println(course);
		System.out.println(type1);
	}

}
