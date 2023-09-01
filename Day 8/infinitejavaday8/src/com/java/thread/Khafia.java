package com.java.thread;

public class Khafia implements Runnable{

	Data data;
	public Khafia(Data data) {
		this.data=data;
	}
	@Override
	public void run() {
		data.shoWMsg("Khafia");
		
	}
}
