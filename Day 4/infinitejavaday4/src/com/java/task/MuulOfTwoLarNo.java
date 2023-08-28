package com.java.task;

import java.math.BigInteger;
import java.util.Scanner;

public class MuulOfTwoLarNo {
	
	public BigInteger Multiply(){
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger(); 
		BigInteger b = sc.nextBigInteger();
		
		BigInteger mul = a.multiply(b);
		return mul;
	}

	public static void main(String[] args) {
		MuulOfTwoLarNo obj = new MuulOfTwoLarNo();
		System.out.println(obj.Multiply());
		
		
	}

}
