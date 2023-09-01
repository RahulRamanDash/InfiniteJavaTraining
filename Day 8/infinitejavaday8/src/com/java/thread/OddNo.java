package com.java.thread;

public class OddNo extends Thread{

	@Override
	public void run() {
		for(int i =1;i<20;i+=2){
			System.out.println("Odd No "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
//	public static void main(String[] args) {
//		OddNo obj = new OddNo();
//		obj.start();;
//
//	}

}
