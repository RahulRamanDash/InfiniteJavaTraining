package com.java.day5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ListIterator;

public class StringSorting {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Sourav");
		list.add("Rahul");
		list.add("Jitendra");
		list.add("Raj");
		list.add("Pranab");
		list.add("Ansal");
		
		Collections.sort(list);
		System.out.println("Sorting in Ascending Order :"+list);
		
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("\nSorting in descending order :"+list);
	}
}