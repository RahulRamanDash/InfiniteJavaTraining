package com.java.gen;

import java.util.Comparator;

public class SortByCgp implements Comparator<Student>{
	@Override
	public int compare(Student e1, Student e2) {
		return (int) (e1.getCgp()-e2.getCgp());
	}

}
