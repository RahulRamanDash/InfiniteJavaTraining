package com.java.day4;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortEx1 {
	public static void main(String[] args) {
		SortedSet names = new TreeSet();
		names.add("Rahul");
		names.add("Rohan");
		names.add("Ganesh");
		names.add("Mukesh");
		names.add("Abhishak");
		
		
		System.out.println("Names are ");
		
		for(Object obj: names){
			System.out.println(obj);
		}
	}

}
