package com.java.abst;

public class AbsEx {

	public static void main(String[] args) {
		Training[] arr = new Training[]{
		new Anirudh(),
		new Rajesh()
		};

		for(Training training : arr){
			training.name();
			training.mail();
		}
		
	}

}
