package com.java.day1;

public class CtoF {
	public void convert(double c){
		 double f = ((c*9)/5)+32;
		 System.out.println(c+"C is Equal to "+f+"F");
	}

	public static void main(String[] args) {
		double c = 37;
		new CtoF().convert(c);
	}

}
