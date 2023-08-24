package com.java.day1;

	public class SwitchCaseString {

		public void check(String dayname){
			switch(dayname){
			case "Sunday":
				System.out.println("This is Sunday");
				break;
			case "Monday":
				System.out.println("This is Monday");
				break;
			case "Tuesday":
				System.out.println("This is Tuesday");
				break;
			case "Wednesday":
				System.out.println("This is Wednesday");
				break;
			case "Thursday":
				System.out.println("This is Thusday");
				break;
			case "Friday":
				System.out.println("This is Friday");
				break;	
			case "Saturday":
				System.out.println("This is Saturday");
				break;	
			}
		}
		public static void main(String[] args) {
			String dayname = "Monday";
			new SwitchCaseString().check(dayname);

		}

	}
