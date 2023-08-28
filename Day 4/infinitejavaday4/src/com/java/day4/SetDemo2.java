package com.java.day4;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo2 {
	
	public static void main(String[] args) {
		

	Set names = new LinkedHashSet();
	names.add("Rahul");
	names.add("Rohan");
	names.add("Ganesh");
	names.add("Mukesh");
	names.add("Abhishak");
	
	names.add("Rahul");
	names.add("Sabyasachi");
	names.add("Ganesh");
	names.add("Mukesh");
	names.add("Abhishak");
	
	for(Object obj: names){
		System.out.println(obj);
	}

}
}
