package com.java.day1;

public class Max3 {

	public void max(int num1,int num2,int num3){
		
		//assuming number1 as max number
		int m = num1;
		if(m<num2){
			m=num2;
		}
		if(m<num3){
			m=num3;
		}
		System.out.println("Maximum value is "+m);
		
		//assuming max value is 0
		int maxval =0;
		if(num1>num2){
			maxval = num1;
		}
		else{
			maxval = num2;
		}
		if (maxval>num3){
			System.out.println("maximum value is "+maxval);
		}
		else{
			System.out.println("maximum value is "+num3);
		}
	}
	public static void main(String[] args) {
		int num1 =10;
		int num2 = 20;
		int num3 = 30;
		new Max3().max(num1, num2, num3);

	}

}
