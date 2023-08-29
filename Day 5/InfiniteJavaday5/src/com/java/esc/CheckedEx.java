package com.java.esc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckedEx {
	private static Scanner sc;

	public void show(String dt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dt);
		System.out.println(date);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter Date Foprmat(Ex: yyyy-MM-dt)");
		String date = sc.next();
		CheckedEx obj = new CheckedEx();
		
		try {
			obj.show(date);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		
	}

}
