package com.java.gen;

import java.util.List;
import java.util.ArrayList;

public class GenEmploy {
	public static void main(String[] args) {
		List<Employ> employlist = new ArrayList<Employ>();
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