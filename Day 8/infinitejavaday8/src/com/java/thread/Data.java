package com.java.thread;

public class Data {
	synchronized void shoWMsg(String name){
		System.out.print("Hello "+name);
		try {
			Thread.sleep(1000);
			System.out.println(" How are you...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
