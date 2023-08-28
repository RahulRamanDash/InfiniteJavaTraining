package com.java.gen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.java.day4.SortByCgp;

public class SortEmploy {

	public static void main(String[] args) {
		Comparator c = new NameComparator();
		SortedSet<Employ>employlist = new TreeSet<Employ>(c);
		employlist.add(new Employ(1,"Arnab",103322));
		employlist.add(new Employ(2,"Ganesh",103321));
		employlist.add(new Employ(3,"Rajesh",103323));
		employlist.add(new Employ(1,"Jitendra",103324));
		employlist.add(new Employ(1,"Pallavi",103325));


		for(Employ employ : employlist){
			System.out.println(employ);
		}
		
	}

}
