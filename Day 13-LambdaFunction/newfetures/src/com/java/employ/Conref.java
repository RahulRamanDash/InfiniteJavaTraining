package com.java.employ;

public class Conref {
	public static void main(String[] args) {
	ITest obj1 = Emp::new;
	Emp e = obj1.showEmploy(1, "Raj", 87045);
	System.out.println(e);
	}
}