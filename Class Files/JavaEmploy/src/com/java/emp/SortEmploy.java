package com.java.emp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEmploy {

	public static void main(String[] args) {
		List<Employ> employList = new ArrayList<Employ>();
		employList.add(new Employ(1,"Rahul",72343));
		employList.add(new Employ(2,"Avesh",72348));
		employList.add(new Employ(3,"Ketan",72328));
		employList.add(new Employ(4,"Priya",72346));
		employList.add(new Employ(5,"Subodh",72342));
		
		System.out.println("Sort By Name ");
		Collections.sort(employList,(s1,s2) -> {
			return s1.getName().compareTo(s2.getName());
		});
		employList.forEach(System.out::println);
		
		Collections.sort(employList,(s1,s2) -> {
			return (int) (s1.getBasic() - s2.getBasic());
		});
		System.out.println("Sort By Basic ");
		employList.forEach(System.out::println);
	}
}
