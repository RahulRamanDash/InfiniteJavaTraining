package com.java.ejb;

import javax.ejb.Remote;

@Remote
public interface CalculationBeanRemote {
	int sum(int x, int y);
	int sub(int a, int b);
	int mult(int a, int b);
}
