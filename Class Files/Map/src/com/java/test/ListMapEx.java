package com.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMapEx {
	public static void main(String[] args) {
		
	List<String> list = new ArrayList<String>();
	list.add("Rahul");
	list.add("Saurav");
	
	System.out.println(list);
	
	Map<String , String> studentlist = new HashMap();
	
	studentlist.put("Name", "Rahul");
	studentlist.put("Gender", "Male");
	
	System.out.println(studentlist);
	}

}


