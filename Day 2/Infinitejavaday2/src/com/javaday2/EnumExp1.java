package com.javaday2;

public class EnumExp1 {
	enum Status{
		ARRIVING, DELAYED, DELIVERED
	}

	public static void main(String[] args) {
		Status status = Status.DELIVERED;
		System.out.println(status);

	}

}
