package com.java.esc;

import java.util.Scanner;

public class Voting {
	public void check(int age) throws VotingExc{
		if(age<18){
			throw new VotingExc("You are not Authorized to vota");
		}
		System.out.println("You can vote...");
	}

	public static void main(String[] args) {
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Age :");
		age = sc.nextInt();
		
		Voting obj = new Voting();
		try {
			obj.check(age);
		} catch (VotingExc e) {
			System.err.println(e.getMessage());
		}
	}

}
