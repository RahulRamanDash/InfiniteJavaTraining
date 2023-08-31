package com.java.task;


public class BinaryToDecimal {
	
	public int binaryToDecimal(String n){
		String num = n;
		int base = 1;
		int dec_val = 0;
		int len = num.length();
		for(int i=len-1; i>=0;i--){
			if(num.charAt(i) == '1'){
				dec_val+=base;
			}
			base = base*2;
		}
		
		return dec_val;
	}

	public static void main(String[] args) {
		BinaryToDecimal obj = new BinaryToDecimal();
		int dec = obj.binaryToDecimal("111");
		System.out.println(dec);

	}

}
