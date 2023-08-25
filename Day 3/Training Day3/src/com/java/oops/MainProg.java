package com.java.oops;

public class MainProg {

	public static void main(String[] args) {
		Training[] arr = new Training[]{
			new Java("OOPS"),
			new Dotnet("Lambda"),
			new Angular("Services"),
			
			new Java("JSP"),
			new Dotnet("Entiti Framework"),
			new Angular("Forms"),
			
			
			new Dotnet("WebApi"),
			new Angular("Components"),
			new Java("Threads"),
			new Java("Jdbc")
			
		};
		for(Training training : arr){
//			if (training instanceof Java){
//			System.out.println(training);
//			System.out.println(training.getClass().getSimpleName());
			if (training.getClass().getSimpleName().equals("Java")) {
				System.out.println(training);
			}
//			}
		}
		

	}

}
