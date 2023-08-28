package com.java.gen;

public class GenericEx1<T> {
	public void swap(T x, T y){
		T t=x;
		x=y;
		y=t;
		System.out.println("Value of x : "+x+" Value of y : "+y);
		
	}

}
