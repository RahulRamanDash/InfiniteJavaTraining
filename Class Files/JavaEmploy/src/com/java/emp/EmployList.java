package com.java.emp;

import java.util.ArrayList;
import java.util.List;

public class EmployList {
	public static void main(String[] args) {
		List<Employ> employList = new ArrayList<Employ>();
		employList.add(new Employ(1,"Rahul",72343));
		employList.add(new Employ(2,"Avesh",72348));
		employList.add(new Employ(3,"Ketan",72328));
		employList.add(new Employ(4,"Priya",72346));
		employList.add(new Employ(5,"Subodh",72342));
		
		System.out.println("Employ Records are ");
		
		employList.forEach(x -> {
			System.out.println(x);
		});
	}

}
