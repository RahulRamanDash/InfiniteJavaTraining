package com.java.day4;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortEmploy {
	public static void main(String[] args) {
		//Comparator c = new NameComparator();
		Comparator d = new BasicComprator();
		
		SortedSet employs = new TreeSet(d);
		
		employs.add(new Employ(1,"Rahul",1033220));
		employs.add(new Employ(2,"Rohan",1033221));
		employs.add(new Employ(3,"Ganesh",1033222));
		employs.add(new Employ(4,"Mukesh",1033225));
		employs.add(new Employ(5,"Abhishak",1033227));
		
		System.out.println("Sorted Data ");
		
		for(Object obj: employs){
			Employ employ = (Employ)obj;
			System.out.println(employ);
		}
	}

}
