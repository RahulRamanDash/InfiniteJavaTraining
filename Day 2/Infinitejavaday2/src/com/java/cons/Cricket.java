package com.java.cons;

public class Cricket {
	static int score;
	public void incriment(int x){
		score+=x;
	}

	public static void main(String[] args) {
		Cricket fb = new Cricket();
		Cricket sb = new Cricket();
		Cricket ext = new Cricket();

		fb.incriment(12);
		sb.incriment(13);
		ext.incriment(3);
		System.out.println(score);
	}

}
