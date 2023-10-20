package com.java.day5;

import java.util.ArrayList;
import java.util.Comparator;

public class SortComparator implements Comparator<String> {
	
	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return s1.length()-s2.length();
	}
	
	public static void main(String[] args) {
	
		ArrayList<String> list1 = new ArrayList<String>();
		
		
		
		list1.add("Sourav");
		list1.add("Ansal");
		list1.add("Rahul");
		
		
		list1.sort(new SortComparator());
		System.out.println(list1);
		
	}

	

	



	

	
	
}
