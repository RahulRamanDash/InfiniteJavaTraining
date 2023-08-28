package com.java.day4;

import java.util.Comparator;

public class SortByName  implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
	
		Student e1= (Student) o1;
		Student e2 = (Student) o2;
		return e2.getName().compareTo(e1.getName());
	}

}
