package com.java.jsf;

import java.util.*;

public class SortArr {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("Rahul");
        arr.add("Ayush");
        arr.add("Ganesh");

        for (int i = 1; i < arr.size(); i++) {
        	if (arr.get(i - 1).compareTo(arr.get(i)) > 0) {
        		String temp = arr.get(i - 1);
                arr.set(i - 1, arr.get(i));
                arr.set(i, temp);
        	}
        }
        System.out.println(arr);
    }
}