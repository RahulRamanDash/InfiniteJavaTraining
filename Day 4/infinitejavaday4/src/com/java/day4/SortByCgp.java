package com.java.day4;

import java.util.Comparator;

public class SortByCgp implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student e1= (Student) o1;
		Student e2 = (Student) o2;
		return (int) (e1.getCgp()-e2.getCgp());
	}

	

}
