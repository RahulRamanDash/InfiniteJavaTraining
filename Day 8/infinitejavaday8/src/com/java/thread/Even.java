package com.java.thread;

public class Even extends Thread{
	@Override
	public void run() {
		for(int i =0;i<20;i+=2){
			System.out.println("Even "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

//	public static void main(String[] args) {
//		Even obj = new Even();
//		obj.start();;
//	}
}
