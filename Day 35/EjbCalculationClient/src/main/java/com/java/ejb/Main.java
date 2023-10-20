package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
	public static void main(String[] args) {
		try {
			CalculationBeanRemote service = 
					(CalculationBeanRemote) new InitialContext().lookup("CalculationBean/remote");
			   System.out.println(service.sum(2, 4));
			   System.out.println(service.sub(9, 7));
			   System.out.println(service.mult(3, 6));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
