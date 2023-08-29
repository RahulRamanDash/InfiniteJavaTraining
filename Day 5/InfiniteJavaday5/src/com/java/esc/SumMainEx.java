package com.java.esc;

import java.util.Scanner;

public class SumMainEx {
	public void sumofno(int num1, int num2) throws SumOfNoEx, NumberZeroEx{
		if(num1 < 0 || num2 < 0){
			throw new SumOfNoEx("Enter Valid Number");
		}
		else if(num1 == 0 || num2 == 0){
			throw new NumberZeroEx("Zero is Invalid Valuse...");
		}
		else{
			int sum = num1+num2;
			System.out.println("Sum is : "+sum);
		}
	}

	public static void main(String[] args){
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Two Number :");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		SumMainEx obj = new SumMainEx();
		try {
			obj.sumofno(num1, num2);
		} catch (SumOfNoEx e) {
			System.err.println(e.getMessage());
		}
		catch(NumberZeroEx e){
			System.err.println(e.getMessage());
		}
		
	}
}
