package com.java.thread;

public class Rahul implements Runnable{

	Data data;
	public Rahul(Data data) {
		this.data=data;
	}
	@Override
	public void run() {
		data.shoWMsg("Rahul");
		
	}
}
