package com.java.day5;

import java.util.ArrayList;
import java.util.Arrays;

public class JoinTwoList {
	public static void main(String[] args) {
		
		ArrayList<String> list1= new ArrayList<String>();
		list1.add("India");
		list1.add("Nepal");
		list1.add("Pakistan");
		System.out.println();
		
		ArrayList<String> list2= new ArrayList<String>();
		list2.add("England");
		list2.add("Australia");
		
		ArrayList<String> mergedList = new ArrayList<String>();
		
		mergedList.addAll(list1);
		mergedList.addAll(list2);
		System.out.println(mergedList);
	}

	
}