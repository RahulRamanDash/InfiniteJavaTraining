package com.javaday2;

public class OverLoadEx2 {
	
	public int sum(){
		return 3;
	}
	public int sum(int x, int y){
		return x+y;
	}

	public static void main(String[] args) {

		OverLoadEx2 obj = new OverLoadEx2();
		int z = obj.sum(20,30);

	}

}
