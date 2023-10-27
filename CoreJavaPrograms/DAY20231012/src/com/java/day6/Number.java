package com.java.day6;

import java.util.Scanner;

public class Number {
	
	public boolean validateNum(String num) {
		boolean flag=false;
		int i=1;
		
		
		if(num.substring(3).length()==10) {
			 flag=true;
		}
		
		
		while( i<num.length()) {
			char c= num.charAt(i);
			if(Character.isDigit(c)) {
				flag = true;
			}
			i++;
			
		}
		
		
		if(num.substring(0, 3).contentEquals("+91")){
			 flag=true;
		}
		
		
		
		
		return flag;
	}
		
	
	public static void main(String[] args) {
		String num;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Your Phone Number ");
		num= sc.next();
		
		Number obj = new Number();
		boolean result = obj.validateNum(num);
		
		
		if(result==true) {
			System.out.println("Valid Phone Number..");
		}else {
			System.out.println("Invalid Phone Number..");
		}
	}
        
         
	}
	
