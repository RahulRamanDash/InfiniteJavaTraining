package com.java.abst;

public class AbsEmploy {

	public static void main(String[] args) {
		Employ[] arr = new Employ[]{
			new Ayush(1,"Ayush",36594),
			new Shivangi(2,"Shivangi",25486),
			new Piyush(3,"Piyush",78526)
		};

		for(Employ employ : arr){
			System.out.println(employ);
		}
	}

}
