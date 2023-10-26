package com.java.day6;

import java.util.HashMap;
import java.util.Map;

public class MapIteration {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Idli", "Good");
		map.put("Dosa", "Average");
		map.put("Rice", "Very Good");
		map.put("Biriyani", "Tasty");
		
		for(Map.Entry<String,String> itr : map.entrySet()) {
			System.out.println(itr.getKey() +":"+ itr.getValue());
		}
	}
}
