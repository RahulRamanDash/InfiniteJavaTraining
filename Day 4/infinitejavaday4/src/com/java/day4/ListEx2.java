package com.java.day4;

import java.util.ArrayList;
import java.util.List;

public class ListEx2 {
	public static void main(String[] args) {
		List data= new ArrayList<>();
		data.add(new Integer(10));
		data.add(new Integer(20));
		data.add(new Integer(30));
		data.add(new Integer(40));
		data.add(new Integer(50));
		
		int sum=0;
		for (Object obj : data){
			int x = (Integer)obj;
			sum+=x;
		}
		System.out.println("sum is : "+sum);
	}

}
