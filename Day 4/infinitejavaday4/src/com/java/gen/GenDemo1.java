package com.java.gen;

import java.util.List;
import java.util.ArrayList;

public class GenDemo1 {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Ankit");
		names.add("Arnam");
		names.add("Rohit");
		names.add("Piyush");
		
		names.add("Rahul");
		System.out.println("Names are");
		for(String s : names){
			System.out.println(s);
		}
		
		
	}

}
