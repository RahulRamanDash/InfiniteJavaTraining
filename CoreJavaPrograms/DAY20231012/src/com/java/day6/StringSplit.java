package com.java.day6;

public class StringSplit {

	public static void main(String[] args) {
		String str = "This is Sourav";
		for(String itr : str.split(" ")) {
			
			System.out.println(itr);
		}
	}
}
