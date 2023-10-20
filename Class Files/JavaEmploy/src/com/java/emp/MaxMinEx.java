package com.java.emp;

import java.util.ArrayList;
import java.util.List;

public class MaxMinEx {

	public static void main(String[] args) {
		List<Employ> employList = new ArrayList<Employ>();
		employList.add(new Employ(1,"Rahul",72343));
		employList.add(new Employ(2,"Avesh",72348));
		employList.add(new Employ(3,"Ketan",72328));
		employList.add(new Employ(4,"Priya",72346));
		employList.add(new Employ(5,"Subodh",72342));
		
		Employ employMax = employList.stream().max((s1,s2) -> 
		s1.getBasic() > s2.getBasic() ? 1 : -1).get();

		Employ employMin = employList.stream().min((s1,s2) -> 
		s1.getBasic() > s2.getBasic() ? 1 : -1).get();
		
		System.out.println("Employ With Max Basic ");
		System.out.println(employMax);
		System.out.println("Employ With Mim Basic ");
		System.out.println(employMin);
	}
}
