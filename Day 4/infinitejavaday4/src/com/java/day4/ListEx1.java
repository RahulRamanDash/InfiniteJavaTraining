package com.java.day4;

import java.util.List;
import java.util.ArrayList;

public class ListEx1 {

	public static void main(String[] args) {
		List names = new ArrayList();
		names.add("Rahul");
		names.add("Rohan");
		names.add("Ganesh");
		names.add("Mukesh");
		names.add("Abhishak");
		System.out.println("Names are");
		
		for(Object obj: names){
			System.out.println(obj);
		}

		names.add(1, "Anirudh");
		System.out.println("Names after adding ");
		for(Object obj: names){
			System.out.println(obj);
		}
		
		names.set(1, "Jitendra");
		System.out.println("Names after Update ");
		for(Object obj: names){
			System.out.println(obj);
		}
		
		names.remove(1);
		System.out.println("Remove by Index ");
		for(Object obj: names){
			System.out.println(obj);
		}
		names.remove("Ganesh");
		System.out.println("Remove by Object Name ");
		for(Object obj: names){
			System.out.println(obj);
		}
	}

}
