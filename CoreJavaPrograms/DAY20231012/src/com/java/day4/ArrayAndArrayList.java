package com.java.day4;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndArrayList {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		//arr[5]=6;
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		List<Integer> arr1 = new ArrayList<>();
		
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		arr1.add(4);
		arr1.add(5);
		arr1.add(6);
		
		
	}

}
