package com.java.thread;

public class DataMain {

	public static void main(String[] args) {
		Data data = new Data();
		Thread t1 = new Thread(new Jitendra(data));
		Thread t2 = new Thread(new Rahul(data));
		Thread t3 = new Thread(new Khafia(data));
		
		t1.start();
		t2.start();
		t3.start();
	}

}
