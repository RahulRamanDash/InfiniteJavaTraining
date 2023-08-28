package com.java.day4;

import java.util.ArrayList;
import java.util.List;

public class ListEmp {

	public static void main(String[] args) {
		List emplist= new ArrayList();
		emplist.add(new Employ(1,"Rahul",1033220));
		emplist.add(new Employ(2,"Rohan",1033221));
		emplist.add(new Employ(3,"Ganesh",1033222));
		emplist.add(new Employ(4,"Mukesh",1033225));
		emplist.add(new Employ(5,"Abhishak",1033227));
		System.out.println("employ list ");
		
		for (Object obj : emplist){
		
			Employ employ = (Employ)obj;
			System.out.println(employ);
		}
	}

}
