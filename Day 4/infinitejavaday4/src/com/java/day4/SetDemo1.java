package com.java.day4;

import java.util.HashSet;
import java.util.Set;

public class SetDemo1 {
	public static void main(String[] args) {
		Set names = new HashSet();
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
