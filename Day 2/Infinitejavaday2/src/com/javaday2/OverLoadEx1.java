package com.javaday2;

public class OverLoadEx1 {

	public void show(int x){
		System.out.println("Show Method Respected to Integer : "+x);
	}
	public void show(double x){
		System.out.println("Show Method Respected to Double : "+x);
	}
	public void show(String x){
		System.out.println("Show Method Respected to String : "+x);
	}
	public static void main(String[] args) {
		
		OverLoadEx1 obj = new OverLoadEx1();
		obj.show(14);
		obj.show(1.2);
		obj.show("Rahul");

	}

}
