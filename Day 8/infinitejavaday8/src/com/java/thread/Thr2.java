package com.java.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Thr2 implements Runnable{

	@Override
	public void run() {
		LinkedList<String> names = new LinkedList<String>();
		names.add("Sourabh");
		names.add("Abhishek");
		names.add("Rajesh");
		names.add("Shivangi");
		names.add("Naveen");
		for (String name : names) {
			System.out.println("LinkedList Data "+name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

