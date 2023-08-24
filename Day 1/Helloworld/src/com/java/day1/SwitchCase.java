package com.java.day1;

public class SwitchCase {

	public void check(int choice){
		switch(choice){
		case 1:
			System.out.println("This is Sunday");
			break;
		case 2:
			System.out.println("This is Monday");
			break;
		case 3:
			System.out.println("This is Tuesday");
			break;
		case 4:
			System.out.println("This is Wednesday");
			break;
		case 5:
			System.out.println("This is Thusday");
			break;
		case 6:
			System.out.println("This is Friday");
			break;	
		case 7:
			System.out.println("This is Saturday");
			break;	
		}
	}
	public static void main(String[] args) {
		int choice = 1;
		new SwitchCase().check(choice);

	}

}
