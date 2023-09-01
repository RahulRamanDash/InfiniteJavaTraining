package com.java.thread;

public class ThrMain {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Thr1());
		Thread t2 = new Thread(new Thr2());
		Thread t3 = new Thread(new Thr3());
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
