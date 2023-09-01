package com.java.thread;

import java.util.ArrayList;
import java.util.List;

public class Thr1 implements Runnable{

	@Override
	public void run() {
		List<String> names = new ArrayList<String>();
		names.add("Ananya");
		names.add("Akanksha");
		names.add("Sanjay");
		names.add("Jitendra");
		names.add("Ayush");
		for (String string : names) {
			System.out.println("ArrayList Data "+string);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
