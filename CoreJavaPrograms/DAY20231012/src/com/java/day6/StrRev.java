package com.java.day6;

public class StrRev {

	public static void main(String[] args) {
		String str = "Sourav";
		for(int i=str.length()-1;i>=0;i--) {
			
			System.out.print(str.charAt(i)+" ");
		}
	}
}