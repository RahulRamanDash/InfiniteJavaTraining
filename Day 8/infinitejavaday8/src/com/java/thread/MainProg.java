package com.java.thread;

public class MainProg {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Even());
		Thread t2 = new Thread(new OddNo());
		Thread t3 = new Thread(new Factorial());
		t1.start();
		t2.start();
		t3.start();
	}

}
