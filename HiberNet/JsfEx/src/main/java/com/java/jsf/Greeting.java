package com.java.jsf;

import java.util.Date;
import java.time.DateTimeException;

public class Greeting {
	public String company() {
		return "Company is Infinite";
	}
	public String saluation() {
		Date obj = new Date();
		int hr = obj.getHours();
		if(hr<=12) {
			return "Good Morning";
		}else if(hr>=12 && hr<=16) {
			return "Good AfterNoon";
		}else {
			return "Good Evening";
		}
	}
}
