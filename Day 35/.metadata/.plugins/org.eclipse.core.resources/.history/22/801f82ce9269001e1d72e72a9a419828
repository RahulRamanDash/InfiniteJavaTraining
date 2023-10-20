package com.java.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculationBean
 */
@Stateless
@Remote(CalculationBeanRemote.class)
public class CalculationBean implements CalculationBeanRemote{

    /**
     * Default constructor. 
     */
    public CalculationBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int mult(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

}
