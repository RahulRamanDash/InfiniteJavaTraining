package com.java.day1;

public class TaskToGoHome {

	
	public void calculate(int unit){
		if (unit<=90){
			double price = unit*1;
			System.out.println(price);
		}
		if (unit>91 && unit<150){
			double price = (90*1) + (unit-90)*1.5;
			System.out.println(price);
		}
		
		if(unit>151 && unit<200){
			double price = (90*1) + (unit-90)*1.5 + (unit-150)*2;
			
		}
		if(unit>200 && unit<240){
			double price = (90*1) + (unit-90)*1.5 + (unit-150)*2 + (unit-200)*2.5;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		int unit = 195;
		new TaskToGoHome().calculate(unit);
	}

}
