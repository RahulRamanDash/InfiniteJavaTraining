package com.java.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculation
 */
@Stateless
@Remote(CalculationRemote.class)
public class Calculation implements CalculationRemote {

    /**
     * Default constructor. 
     */
    public Calculation() {
    }

	@Override
	public int sum(int x, int y) {
		return x+y;
	}

	@Override
	public int sub(int x, int y) {
		return x-y;
	}

	@Override
	public int mult(int x, int y) {
		return x*y;
	}

}
