package com.java.test;

import java.util.Hashtable;
import java.util.Map;

public class Data {
	public boolean evenOdd(int n) {
		if(n%2==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public Object mapEx(String key) {
		Map data = new Hashtable();
		data.put("Ganesh", "Mirda");
		data.put("Tanya", "Arora");
		data.put("Sagar", "Mukkawr");
		data.put("Rahul", "Raman");
		return data.get(key);
	}
	public String sayHello() {
		return "Welcome to Junit Programming....";
	}
	public int sum(int x, int y) {
		return x+y;
	}
	public int max3(int a, int b, int c) {
		int m=a;
		if (m<b) {
			m=b;
		}
		if (m<c) {
			m=c;
		}
		return m;
	}

}
