package com.java.cons;

public class ConsOverload {
	int a,b;
	ConsOverload(){
		a=5;
		b=7;
	}
	ConsOverload(int a, int b){
		this.a=a;
		this.b=b;
	}

	@Override
	public String toString() {
		return "ConsOverload [a=" + a + ", b=" + b + "]";
	}
	
	public static void main(String[] args) {
		ConsOverload obj = new ConsOverload();
		System.out.println(obj);
		ConsOverload obj1 = new ConsOverload(5,4);
		System.out.println(obj1);
		
		

	}
	

}
