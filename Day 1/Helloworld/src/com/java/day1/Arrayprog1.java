package com.java.day1;

public class Arrayprog1 {
	public void show(){
		int[] arr = new int[]{5,10,15,20,25};
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		new Arrayprog1().show();

	}

}
