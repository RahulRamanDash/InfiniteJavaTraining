package com.java.day1;

public class Factors {
	public void show(int num){
		for(int i = 1;i<=num;i++){
			if(num%i==0){
				
				System.out.println("Factor "+i);
			}
		}
	}
	
	public static void main(String []args){
		int num = 20;
		new Factors().show(num);
	}
}
