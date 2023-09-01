package com.java.thread;

public class ThreadEx1 extends Thread{
	public static void main(String[] args) {
	ThreadEx1 thread = new ThreadEx1();
		thread.start();
	}
	public void run(){
		System.out.println("The code is running in Thread");
	}


}