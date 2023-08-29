package com.java.mailesc;

import java.util.Scanner;

import com.java.esc.SumOfNoEx;

public class MailEsc {
	public void check(String mail) throws InvalidEmailEsc, InvalidUserEsc{
		String[] username = mail.split("@"); 
		//System.out.println(username[0]);
		if(mail.contains("@")){
			if(username[0].length()< 10){
				throw new InvalidUserEsc("Invalid User");
			}
			else{
				System.out.println(mail);
			}
		}
		else{
			throw new InvalidEmailEsc("Invalid Email");
		}
	}
	public static void main(String[] args) {
		String mail;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Mail Id : ");
		mail = sc.next();
		
		MailEsc obj = new MailEsc();
		try {
			obj.check(mail);
		} catch (InvalidEmailEsc e) {
			System.err.println(e.getMessage());
		} catch (InvalidUserEsc e) {
			System.err.println(e.getMessage());;
		}
	}

}
