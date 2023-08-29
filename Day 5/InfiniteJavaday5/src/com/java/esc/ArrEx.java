package com.java.esc;

public class ArrEx {

	public static void main(String[] args) {
		int[] arr = new int[]{2, 4};
		
		
		try {
			arr[10]=88;
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Array Size is Small...");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
