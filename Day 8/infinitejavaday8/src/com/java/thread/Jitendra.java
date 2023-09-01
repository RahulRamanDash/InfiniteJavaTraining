package com.java.thread;

public class Jitendra implements Runnable{

	Data data;
	public Jitendra(Data data) {
		this.data=data;
	}
	@Override
	public void run() {
		data.shoWMsg("Jitendra");
		
	}
	

}
